package models;

public class Cidade {
    private int idCidade;
    private UnidadeFederacao unidadeFederacao; // relacionamento com UnidadeFederacao
    private String nomeCidade;

    public Cidade() {
    }

    public Cidade(int idCidade, UnidadeFederacao unidadeFederacao, String nomeCidade) {
        this.idCidade = idCidade;
        this.unidadeFederacao = unidadeFederacao;
        this.nomeCidade = nomeCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", unidadeFederacao=" + unidadeFederacao +
                ", nomeCidade='" + nomeCidade + '\'' +
                '}';
    }
}
