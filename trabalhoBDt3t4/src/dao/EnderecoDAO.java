package dao;

import database.PostgresDatabaseConnection;
import models.Endereco;

import java.sql.*;

public class EnderecoDAO {
	private Connection connection;

    public EnderecoDAO(Connection connection) {
        this.connection = connection;
    }
    public int cadastrarEndereco(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO Endereco (CEP, IdCidade, IdBairro, IdLogradouro) VALUES (?, ?, ?, ?)";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            // Supondo que no model Endereco existem:
            // private int cep;
            // private Cidade cidade; // e cidade.getIdCidade() retorna o ID
            // private Bairro bairro; // e bairro.getIdBairro() retorna o ID
            // private Logradouro logradouro; // e logradouro.getIdLogradouro() retorna o ID

            ps.setInt(1, endereco.getCep());
            ps.setInt(2, endereco.getCidade().getIdCidade());
            ps.setInt(3, endereco.getBairro().getIdBairro());
            ps.setInt(4, endereco.getLogradouro().getIdLogradouro());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    endereco.setIdEndereco(idGerado);
                    return idGerado;
                } else {
                    throw new SQLException("Erro ao cadastrar Endereço, não foi possível obter o ID.");
                }
            }
        }
    }
}
