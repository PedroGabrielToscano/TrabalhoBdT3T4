package models;

import java.util.List;

public class Fornecedor {
    private int idFornecedor;
    private String cnpj;
    private String nome;
    private Endereco endereco;
    private double saldoAPagar;
    private EnderecoEspecifico enderecoEspecifico;
    private List<EmailFornecedor> listaEmails;
    private List<FoneFornecedor> listaFones;


    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String cnpj, String nome, Endereco endereco, double saldoAPagar, EnderecoEspecifico enderecoEspecifico) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.saldoAPagar = saldoAPagar;
        this.enderecoEspecifico = enderecoEspecifico;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getSaldoAPagar() {
        return saldoAPagar;
    }

    public void setSaldoAPagar(double saldoAPagar) {
        this.saldoAPagar = saldoAPagar;
    }

    public EnderecoEspecifico getEnderecoEspecifico() {
        return enderecoEspecifico;
    }

    public void setEnderecoEspecifico(EnderecoEspecifico enderecoEspecifico) {
        this.enderecoEspecifico = enderecoEspecifico;
    }
    public List<EmailFornecedor> getListaEmails() {
        return listaEmails;
    }

    public void setListaEmails(List<EmailFornecedor> listaEmails) {
        this.listaEmails = listaEmails;
    }

    public List<FoneFornecedor> getListaFones() {
        return listaFones;
    }

    public void setListaFones(List<FoneFornecedor> listaFones) {
        this.listaFones = listaFones;
    }


    @Override
    public String toString() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", saldoAPagar=" + saldoAPagar +
                ", enderecoEspecifico=" + enderecoEspecifico +
                '}';
    }
}
