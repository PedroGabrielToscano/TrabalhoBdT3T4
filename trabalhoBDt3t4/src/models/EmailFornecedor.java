package models;

public class EmailFornecedor {
    private int idEmail;
    private Fornecedor fornecedor;
    private String emailFornecedor;

    public EmailFornecedor() {
    }

    public EmailFornecedor(int idEmail, Fornecedor fornecedor, String emailFornecedor) {
        this.idEmail = idEmail;
        this.fornecedor = fornecedor;
        this.emailFornecedor = emailFornecedor;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getEmailFornecedor() {
        return emailFornecedor;
    }

    public void setEmailFornecedor(String emailFornecedor) {
        this.emailFornecedor = emailFornecedor;
    }

    @Override
    public String toString() {
        return "EmailFornecedor{" +
                "idEmail=" + idEmail +
                ", fornecedor=" + fornecedor +
                ", emailFornecedor='" + emailFornecedor + '\'' +
                '}';
    }
}
