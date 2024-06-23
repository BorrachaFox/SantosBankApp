package main.java.bank.transacao;

import main.java.bank.conta.Conta;

import java.util.Date;

public class Transacao {
    protected final Date data;
    protected final TipoTransacao tipoTransacao;
    protected final double valor;
    protected final Conta conta;

    public Transacao(double valor, Conta conta, TipoTransacao tipoTransacao) {
        this.data = new Date();
        this.conta = conta;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public Date getData() {
        return data;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public double getValor() {
        return valor;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", tipoTransacao=" + tipoTransacao +
                ", valor=" + valor +
                '}';
    }
}
