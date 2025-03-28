package dao;

import database.PostgresDatabaseConnection;
import models.DDIFornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DDIFornecedorDAO {
	private Connection connection;

    public DDIFornecedorDAO(Connection connection) {
        this.connection = connection;
    }
    public List<DDIFornecedor> listarDDI() throws SQLException {
        List<DDIFornecedor> lista = new ArrayList<>();
        String sql = "SELECT Id_DDIFornecedor, DDI FROM DDIFornecedor";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                DDIFornecedor ddi = new DDIFornecedor();
                ddi.setIdDDIFornecedor(rs.getInt("Id_DDIFornecedor"));
                ddi.setDdi(rs.getString("DDI"));
                lista.add(ddi);
            }
        }
        return lista;
    }
}
