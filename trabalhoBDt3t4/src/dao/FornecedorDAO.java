package dao;

import database.PostgresDatabaseConnection;
import models.Bairro;
import models.Cidade;
import models.EmailFornecedor;
import models.Endereco;
import models.EnderecoEspecifico;
import models.FoneFornecedor;
import models.Fornecedor;
import models.Logradouro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    private Connection connection;

    public FornecedorDAO(Connection connection) {
        this.connection = connection;
    }
	public List<Fornecedor> listarFornecedoresComContatos() {
	    List<Fornecedor> lista = new ArrayList<>();
	    String sql = "SELECT f.idfornecedor, f.cnpj, f.nome, f.saldoapagar, " +
	                 "       (f.enderecoespecifico).numeroend as numeroend, " +
	                 "       (f.enderecoespecifico).complemento as complemento, " +
	                 "       e.idendereco, e.cep, " +
	                 "       c.idcidade, c.nomecidade, " +
	                 "       b.idbairro, b.nomebairro, " +
	                 "       l.idlogradouro, l.nomelogradouro " +
	                 "FROM fornecedor f " +
	                 "LEFT JOIN Endereco e ON f.idendereco = e.idendereco " +
	                 "LEFT JOIN Cidade c ON e.idcidade = c.idcidade " +
	                 "LEFT JOIN Bairro b ON e.idbairro = b.idbairro " +
	                 "LEFT JOIN Logradouro l ON e.idlogradouro = l.idlogradouro";
	    try (Connection conn = PostgresDatabaseConnection.getConnection();
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	         while (rs.next()){
	             Fornecedor fornecedor = new Fornecedor();
	             fornecedor.setIdFornecedor(rs.getInt("idfornecedor"));
	             fornecedor.setCnpj(rs.getString("cnpj"));
	             fornecedor.setNome(rs.getString("nome"));
	             fornecedor.setSaldoAPagar(rs.getDouble("saldoapagar"));

	             // Recupera os dados do endereço específico
	             int numeroEnd = rs.getInt("numeroend");
	             String complemento = rs.getString("complemento");
	             EnderecoEspecifico endEsp = new EnderecoEspecifico();
	             endEsp.setNumeroEnd(numeroEnd);
	             endEsp.setComplemento(complemento);
	             fornecedor.setEnderecoEspecifico(endEsp);

	             int idEndereco = rs.getInt("idendereco");
	             if (!rs.wasNull()){
	                 Endereco endereco = new Endereco();
	                 endereco.setIdEndereco(idEndereco);
	                 endereco.setCep(rs.getInt("cep"));

	                 Cidade cidade = new Cidade();
	                 cidade.setIdCidade(rs.getInt("idcidade"));
	                 cidade.setNomeCidade(rs.getString("nomecidade"));
	                 endereco.setCidade(cidade);

	                 Bairro bairro = new Bairro();
	                 bairro.setIdBairro(rs.getInt("idbairro"));
	                 bairro.setNomeBairro(rs.getString("nomebairro"));
	                 endereco.setBairro(bairro);

	                 Logradouro logradouro = new Logradouro();
	                 logradouro.setIdLogradouro(rs.getInt("idlogradouro"));
	                 logradouro.setNomeLogradouro(rs.getString("nomelogradouro"));
	                 endereco.setLogradouro(logradouro);

	                 fornecedor.setEndereco(endereco);
	             }

	             // Carrega e-mails e fones conforme implementação existente
	             fornecedor.setListaEmails(listarEmailsFornecedor(fornecedor.getIdFornecedor(), conn));
	             fornecedor.setListaFones(listarFonesFornecedor(fornecedor.getIdFornecedor(), conn));

	             lista.add(fornecedor);
	         }
	    } catch (SQLException e) {
	         e.printStackTrace();
	    }
	    return lista;
	}
	public void cadastrarEmailFornecedor(Fornecedor fornecedor, String email) throws SQLException {
	    String sql = "INSERT INTO EmailFornecedor (IdFornecedor, EmailFornecedor) VALUES (?, ?)";
	    try (Connection conn = PostgresDatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, fornecedor.getIdFornecedor());
	        ps.setString(2, email);
	        ps.executeUpdate();
	    }
	}

	public void cadastrarFoneFornecedor(Fornecedor fornecedor, int idDDI, int idDDD, String telefone) throws SQLException {
	    String sql = "INSERT INTO FoneFornecedor (IDFornecedor, Id_DDIFornecedor, Id_DDDFornecedor, NrofoneFornecedor) VALUES (?, ?, ?, ?)";
	    try (Connection conn = PostgresDatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, fornecedor.getIdFornecedor());
	        ps.setInt(2, idDDI);
	        ps.setInt(3, idDDD);
	        ps.setString(4, telefone);
	        ps.executeUpdate();
	    }
	}



    private List<EmailFornecedor> listarEmailsFornecedor(int idFornecedor, Connection conn) {
        List<EmailFornecedor> listaEmails = new ArrayList<>();
        String sql = "SELECT idemail, emailfornecedor FROM emailfornecedor WHERE idfornecedor = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFornecedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EmailFornecedor email = new EmailFornecedor();
                email.setIdEmail(rs.getInt("idemail"));
                email.setEmailFornecedor(rs.getString("emailfornecedor"));
                listaEmails.add(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEmails;
    }

    private List<FoneFornecedor> listarFonesFornecedor(int idFornecedor, Connection conn) {
        List<FoneFornecedor> listaFones = new ArrayList<>();
        String sql = "SELECT ff.idfone, ff.nrofonefornecedor, ddi.ddi, ddd.ddd " +
                     "FROM fonefornecedor ff " +
                     "JOIN ddifornecedor ddi ON ff.id_ddifornecedor = ddi.id_ddifornecedor " +
                     "JOIN dddfornecedor ddd ON ff.id_dddfornecedor = ddd.id_dddfornecedor " +
                     "WHERE ff.idfornecedor = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idFornecedor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FoneFornecedor fone = new FoneFornecedor();
                fone.setIdFone(rs.getInt("idfone"));
                String ddi = rs.getString("ddi");
                String ddd = rs.getString("ddd");
                String numero = rs.getString("nrofonefornecedor");
                fone.setNroFoneFornecedor(ddi + " (" + ddd + ") " + numero);

                listaFones.add(fone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFones;
    }
    
    /**
     * Cadastra um novo fornecedor no banco de dados, permitindo que o banco gere automaticamente o ID.
     */
    public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        String sql = "INSERT INTO fornecedor (cnpj, nome, idendereco, saldoapagar, enderecoespecifico) " +
                     "VALUES (?, ?, ?, ?, ROW(?, ?))";
                     
        try (Connection conn = PostgresDatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, fornecedor.getCnpj());
            ps.setString(2, fornecedor.getNome());
            ps.setInt(3, fornecedor.getEndereco().getIdEndereco());
            ps.setDouble(4, fornecedor.getSaldoAPagar());
            ps.setInt(5, fornecedor.getEnderecoEspecifico().getNumeroEnd());
            ps.setString(6, fornecedor.getEnderecoEspecifico().getComplemento());

            ps.executeUpdate();

            // Recupera o ID gerado e o atribui ao objeto fornecedor
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    fornecedor.setIdFornecedor(rs.getInt(1));
                }
            }
        }
    }
}
