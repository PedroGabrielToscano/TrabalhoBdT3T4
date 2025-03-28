package models;

public class UnidadeFederacao {
    private int idUF;
    private String nomeUF;

    public UnidadeFederacao() {
    }

    public UnidadeFederacao(int idUF, String nomeUF) {
        this.idUF = idUF;
        this.nomeUF = nomeUF;
    }

    public int getIdUF() {
        return idUF;
    }

    public void setIdUF(int idUF) {
        this.idUF = idUF;
    }

    public String getNomeUF() {
        return nomeUF;
    }

    public void setNomeUF(String nomeUF) {
        this.nomeUF = nomeUF;
    }

    @Override
    public String toString() {
        return "UnidadeFederacao{" +
                "idUF=" + idUF +
                ", nomeUF='" + nomeUF + '\'' +
                '}';
    }
}
