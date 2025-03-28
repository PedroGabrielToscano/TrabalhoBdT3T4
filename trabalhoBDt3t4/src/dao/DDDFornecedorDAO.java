package dao;

import database.PostgresDatabaseConnection;
import models.DDDFornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DDDFornecedorDAO {
	private Connection connection;

    public DDDFornecedorDAO(Connection connection) {
        this.connection = connection;
    }
    public List<DDDFornecedor> listarDDD() throws SQLException {
        List<DDDFornecedor> lista = new ArrayList<>();
        String sql = "SELECT Id_DDDFornecedor, DDD FROM DDDFornecedor";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                DDDFornecedor ddd = new DDDFornecedor();
                ddd.setIdDDDFornecedor(rs.getInt("Id_DDDFornecedor"));
                ddd.setDdd(rs.getString("DDD"));
                lista.add(ddd);
            }
        }
        return lista;
    }
}
