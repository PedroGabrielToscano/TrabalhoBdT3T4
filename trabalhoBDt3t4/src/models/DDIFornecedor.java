package models;

public class DDIFornecedor {
    private int idDDIFornecedor;
    private String ddi;

    public DDIFornecedor() {
    }

    public DDIFornecedor(int idDDIFornecedor, String ddi) {
        this.idDDIFornecedor = idDDIFornecedor;
        this.ddi = ddi;
    }

    public int getIdDDIFornecedor() {
        return idDDIFornecedor;
    }

    public void setIdDDIFornecedor(int idDDIFornecedor) {
        this.idDDIFornecedor = idDDIFornecedor;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    @Override
    public String toString() {
        return "DDIFornecedor{" +
                "idDDIFornecedor=" + idDDIFornecedor +
                ", ddi='" + ddi + '\'' +
                '}';
    }
}
