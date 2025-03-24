package models;

public class TipoLogradouro {
    private int idTipoLogradouro;
    private String nomeTipoLogradouro;

    public TipoLogradouro() {
    }

    public TipoLogradouro(int idTipoLogradouro, String nomeTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    public int getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(int idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    @Override
    public String toString() {
        return "TipoLogradouro{" +
                "idTipoLogradouro=" + idTipoLogradouro +
                ", nomeTipoLogradouro='" + nomeTipoLogradouro + '\'' +
                '}';
    }
}
