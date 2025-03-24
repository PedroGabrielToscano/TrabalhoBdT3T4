package models;

public class Logradouro {
    private int idLogradouro;
    private String nomeLogradouro;
    private TipoLogradouro tipoLogradouro;

    public Logradouro() {
    }

    public Logradouro(int idLogradouro, String nomeLogradouro, TipoLogradouro tipoLogradouro) {
        this.idLogradouro = idLogradouro;
        this.nomeLogradouro = nomeLogradouro;
        this.tipoLogradouro = tipoLogradouro;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    @Override
    public String toString() {
        return "Logradouro{" +
                "idLogradouro=" + idLogradouro +
                ", nomeLogradouro='" + nomeLogradouro + '\'' +
                ", tipoLogradouro=" + tipoLogradouro +
                '}';
    }
}
