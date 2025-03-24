package dao;

import database.PostgresDatabaseConnection;
import models.Bairro;

import java.sql.*;

public class BairroDAO {
	private Connection connection;

    public BairroDAO(Connection connection) {
        this.connection = connection;
    }
    public int cadastrarBairro(Bairro bairro) throws SQLException {
        String sql = "INSERT INTO Bairro (NomeBairro) VALUES (?)";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, bairro.getNomeBairro());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    bairro.setIdBairro(id);
                    return id;
                } else {
                    throw new SQLException("Erro ao cadastrar Bairro, não foi possível obter o ID.");
                }
            }
        }
    }
}
