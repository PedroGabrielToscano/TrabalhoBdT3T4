package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.PostgresDatabaseConnection;
import models.UnidadeFederacao;

public class UnidadeFederacaoDAO {
	private Connection connection;

    public UnidadeFederacaoDAO(Connection connection) {
        this.connection = connection;
    }
    public List<UnidadeFederacao> listarUFs() throws SQLException {
        List<UnidadeFederacao> lista = new ArrayList<>();
        String sql = "SELECT iduf, nomeuf FROM unidade_federacao";
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                UnidadeFederacao uf = new UnidadeFederacao();
                uf.setIdUF(rs.getInt("iduf"));
                uf.setNomeUF(rs.getString("nomeuf"));
                lista.add(uf);
            }
        }
        return lista;
    }

}
