package models;

public class DDDFornecedor {
    private int idDDDFornecedor;
    private String ddd;

    public DDDFornecedor() {
    }

    public DDDFornecedor(int idDDDFornecedor, String ddd) {
        this.idDDDFornecedor = idDDDFornecedor;
        this.ddd = ddd;
    }

    public int getIdDDDFornecedor() {
        return idDDDFornecedor;
    }

    public void setIdDDDFornecedor(int idDDDFornecedor) {
        this.idDDDFornecedor = idDDDFornecedor;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "DDDFornecedor{" +
                "idDDDFornecedor=" + idDDDFornecedor +
                ", ddd='" + ddd + '\'' +
                '}';
    }
}
