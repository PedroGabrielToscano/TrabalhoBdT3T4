package dao;

import database.PostgresDatabaseConnection;
import models.Logradouro;
import models.TipoLogradouro;

import java.sql.*;

public class LogradouroDAO {
	private Connection connection;

    public LogradouroDAO(Connection connection) {
        this.connection = connection;
    }
    public int cadastrarLogradouro(Logradouro logradouro) throws SQLException {
        String sql = "INSERT INTO Logradouro (NomeLogradouro, IdTipoLogradouro) VALUES (?, ?)";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, logradouro.getNomeLogradouro());
            ps.setInt(2, logradouro.getTipoLogradouro().getIdTipoLogradouro());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    logradouro.setIdLogradouro(id);
                    return id;
                } else {
                    throw new SQLException("Erro ao cadastrar Logradouro, não foi possível obter o ID.");
                }
            }
        }
    }
}
