package models;

public class EnderecoEspecifico {
    private int numeroEnd;
    private String complemento;

    public EnderecoEspecifico() {
    }

    public EnderecoEspecifico(int numeroEnd, String complemento) {
        this.numeroEnd = numeroEnd;
        this.complemento = complemento;
    }

    public int getNumeroEnd() {
        return numeroEnd;
    }

    public void setNumeroEnd(int numeroEnd) {
        this.numeroEnd = numeroEnd;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "EnderecoEspecifico{" +
                "numeroEnd=" + numeroEnd +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
