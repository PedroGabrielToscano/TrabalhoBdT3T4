package models;

public class FoneFornecedor {
    private int idFone;
    private Fornecedor fornecedor;
    private DDIFornecedor ddiFornecedor;
    private DDDFornecedor dddFornecedor;
    private String nroFoneFornecedor;

    public FoneFornecedor() {
    }

    public FoneFornecedor(int idFone, Fornecedor fornecedor, DDIFornecedor ddiFornecedor, DDDFornecedor dddFornecedor, String nroFoneFornecedor) {
        this.idFone = idFone;
        this.fornecedor = fornecedor;
        this.ddiFornecedor = ddiFornecedor;
        this.dddFornecedor = dddFornecedor;
        this.nroFoneFornecedor = nroFoneFornecedor;
    }

    public int getIdFone() {
        return idFone;
    }

    public void setIdFone(int idFone) {
        this.idFone = idFone;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public DDIFornecedor getDdiFornecedor() {
        return ddiFornecedor;
    }

    public void setDdiFornecedor(DDIFornecedor ddiFornecedor) {
        this.ddiFornecedor = ddiFornecedor;
    }

    public DDDFornecedor getDddFornecedor() {
        return dddFornecedor;
    }

    public void setDddFornecedor(DDDFornecedor dddFornecedor) {
        this.dddFornecedor = dddFornecedor;
    }

    public String getNroFoneFornecedor() {
        return nroFoneFornecedor;
    }

    public void setNroFoneFornecedor(String nroFoneFornecedor) {
        this.nroFoneFornecedor = nroFoneFornecedor;
    }

    @Override
    public String toString() {
        return "FoneFornecedor{" +
                "idFone=" + idFone +
                ", fornecedor=" + fornecedor +
                ", ddiFornecedor=" + ddiFornecedor +
                ", dddFornecedor=" + dddFornecedor +
                ", nroFoneFornecedor='" + nroFoneFornecedor + '\'' +
                '}';
    }
}
