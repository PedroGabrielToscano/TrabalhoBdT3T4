package models;

import java.time.LocalDate;

public class Fatura {
    private int idFatura;
    private Fornecedor fornecedor;
    private double valorFatura;
    private MotivoFatura motivoFatura;
    private LocalDate dtVencimento;
    private LocalDate dtLancamento;

    public Fatura() {
    }

    public Fatura(int idFatura, Fornecedor fornecedor, double valorFatura, MotivoFatura motivoFatura, LocalDate dtVencimento, LocalDate dtLancamento) {
        this.idFatura = idFatura;
        this.fornecedor = fornecedor;
        this.valorFatura = valorFatura;
        this.motivoFatura = motivoFatura;
        this.dtVencimento = dtVencimento;
        this.dtLancamento = dtLancamento;
    }

    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        this.valorFatura = valorFatura;
    }

    public MotivoFatura getMotivoFatura() {
        return motivoFatura;
    }

    public void setMotivoFatura(MotivoFatura motivoFatura) {
        this.motivoFatura = motivoFatura;
    }

    public LocalDate getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(LocalDate dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public LocalDate getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(LocalDate dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "idFatura=" + idFatura +
                ", fornecedor=" + fornecedor +
                ", valorFatura=" + valorFatura +
                ", motivoFatura=" + motivoFatura +
                ", dtVencimento=" + dtVencimento +
                ", dtLancamento=" + dtLancamento +
                '}';
    }
}
