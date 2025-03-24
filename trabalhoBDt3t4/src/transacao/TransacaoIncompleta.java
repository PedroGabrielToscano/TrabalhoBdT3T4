package transacao;

import dao.FaturaDAO;
import dao.FornecedorDAO;
import models.Fatura;
import models.Fornecedor;
import models.MotivoFatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;

public class TransacaoIncompleta {
    public static void executarTransacaoIncompleta(Connection conn) throws Exception {
        conn.setAutoCommit(false);
        // Instancia os DAOs com a conexão passada
        FaturaDAO faturaDAO = new FaturaDAO(conn);
        FornecedorDAO fornecedorDAO = new FornecedorDAO(conn);
        
        // INSERT em fatura
        String sqlInsert = "INSERT INTO fatura (idfatura, idfornecedor, valorfatura, idmotivo, dtvencimento, dtlancamento) " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
            int novoIdFatura = 2001; // Exemplo
            psInsert.setInt(1, novoIdFatura);
            psInsert.setInt(2, 2); // ID do fornecedor (use um ID válido)
            psInsert.setDouble(3, 750.0);
            psInsert.setInt(4, 2); // ID do motivo
            psInsert.setDate(5, Date.valueOf(LocalDate.now().plusDays(15)));
            psInsert.setDate(6, Date.valueOf(LocalDate.now()));
            psInsert.executeUpdate();
        }
        
        // UPDATE em fornecedor
        String sqlUpdate = "UPDATE fornecedor SET saldoapagar = saldoapagar + ? WHERE idfornecedor = ?";
        try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
            psUpdate.setDouble(1, 750.0);
            psUpdate.setInt(2, 2);
            psUpdate.executeUpdate();
        }
        
        System.out.println("Transação Incompleta: encerrando sem commit/rollback.");
        // Encerra abruptamente sem commit ou rollback
        System.exit(1);
    }
}
