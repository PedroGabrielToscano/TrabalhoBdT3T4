package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.PostgresDatabaseConnection;
import models.TipoLogradouro;

public class TipoLogradouroDAO {
	private Connection connection;

    public TipoLogradouroDAO(Connection connection) {
        this.connection = connection;
    }
	public List<TipoLogradouro> listarTipoLogradouros() throws SQLException {
	    List<TipoLogradouro> lista = new ArrayList<>();
	    String sql = "SELECT idtipologradouro, nometipologradouro FROM tipologradouro";
	    try (Connection conn = PostgresDatabaseConnection.getConnection();
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {
	        while (rs.next()) {
	            TipoLogradouro t = new TipoLogradouro();
	            t.setIdTipoLogradouro(rs.getInt("idtipologradouro"));
	            t.setNomeTipoLogradouro(rs.getString("nometipologradouro"));
	            lista.add(t);
	        }
	    }
	    return lista;
	}

}
