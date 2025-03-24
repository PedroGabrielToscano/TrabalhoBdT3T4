package models;

public class Bairro {
    private int idBairro;
    private String nomeBairro;

    public Bairro() {
    }

    public Bairro(int idBairro, String nomeBairro) {
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "idBairro=" + idBairro +
                ", nomeBairro='" + nomeBairro + '\'' +
                '}';
    }
}
