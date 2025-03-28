package transacao;

import dao.FaturaDAO;
import dao.FornecedorDAO;
import models.Fatura;
import models.Fornecedor;
import models.MotivoFatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class TransacaoRollback {
    public static void executarTransacaoRollback(Connection conn) throws Exception {
        conn.setAutoCommit(false);
        // Instancia os DAOs com a conexão passada
        FaturaDAO faturaDAO = new FaturaDAO(conn);
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conn);
        
        try {
            // INSERT em fatura
            String sqlInsert = "INSERT INTO fatura (idfatura, idfornecedor, valorfatura, idmotivo, dtvencimento, dtlancamento) " +
                               "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                int novoIdFatura = 3001; // Exemplo
                psInsert.setInt(1, novoIdFatura);
                psInsert.setInt(2, 2); // ID do fornecedor (use um ID válido)
                psInsert.setDouble(3, 1000.0);
                psInsert.setInt(4, 1); // ID do motivo
                psInsert.setDate(5, Date.valueOf(LocalDate.now().plusDays(20)));
                psInsert.setDate(6, Date.valueOf(LocalDate.now()));
                psInsert.executeUpdate();
            }
            
            // UPDATE em fornecedor
            String sqlUpdate = "UPDATE fornecedor SET saldoapagar = saldoapagar + ? WHERE idfornecedor = ?";
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setDouble(1, 1000.0);
                psUpdate.setInt(2, 3); // Certifique-se de que esse ID existe
                psUpdate.executeUpdate();
            }
            
            // Lança exceção intencional para forçar rollback
            throw new Exception("Erro simulado: abortando a transação com rollback.");
        } catch (Exception e) {
            try {
                conn.rollback();
                System.out.println("Rollback executado com sucesso: " + e.getMessage());
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } finally {
            try {
                if (conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
