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

public class TransacaoOK {
    public static void executarTransacaoOK(Connection conn) throws Exception {
        conn.setAutoCommit(false);
        // Instancia os DAOs com a conexão passada
        FaturaDAO faturaDAO = new FaturaDAO(conn);
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conn);
        
        try {
            // INSERT em fatura
            String sqlInsert = "INSERT INTO fatura (idfatura, idfornecedor, valorfatura, idmotivo, dtvencimento, dtlancamento) " +
                               "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                int novoIdFatura = 1030; // Exemplo
                psInsert.setInt(1, novoIdFatura);
                psInsert.setInt(2, 1); // ID do fornecedor (use um ID válido)
                psInsert.setDouble(3, 500.0);
                psInsert.setInt(4, 1); // ID do motivo
                psInsert.setDate(5, Date.valueOf(LocalDate.now().plusDays(30)));
                psInsert.setDate(6, Date.valueOf(LocalDate.now()));
                psInsert.executeUpdate();
            }
            
            // UPDATE em fornecedor
            String sqlUpdate = "UPDATE fornecedor SET saldoapagar = saldoapagar + ? WHERE idfornecedor = ?";
            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setDouble(1, 500.0);
                psUpdate.setInt(2, 1);
                psUpdate.executeUpdate();
            }
            
            conn.commit();
            System.out.println("Transação OK concluída com sucesso!");
        } catch (Exception e) {
            conn.rollback();
            throw new Exception("Erro na transação OK: " + e.getMessage(), e);
        }
    }
}
