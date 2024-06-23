package main.java.bank.conta;

import main.java.bank.cliente.Cliente;
import main.java.bank.transacao.TipoTransacao;
import main.java.bank.transacao.Transacao;
import main.java.bank.transacao.Transferencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente titular;
    protected List<Transacao> transacoes = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.titular = cliente;
    }

    @Override
    public void sacar(double valor) {
        sacar(valor, true);
    }

    @Override
    public void sacar(double valor, boolean geraTransacao) {
        if (valor > saldo) {
            System.out.print("Saldo Insuficiente");
            return;
        }

        saldo -= valor;
        if (geraTransacao) this.transacoes.add(new Transacao(valor, this, TipoTransacao.SAQUE));
    }

    @Override
    public void depositar(double valor) {
        depositar(valor, true);
    }

    @Override
    public void depositar(double valor, boolean geraTransacao) {
        saldo += valor;
        if (geraTransacao)  this.transacoes.add(new Transacao(valor, this, TipoTransacao.DEPOSITO));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > saldo) {
            System.out.print("Saldo Insuficiente");
            return;
        }

        this.sacar(valor, false); // ! o valor vai ser checado 2 vezes | Poderia ter uma Exception
        contaDestino.depositar(valor, false);
        this.transacoes.add(new Transferencia(valor, this, contaDestino));

        System.out.printf("%s:\n", titular.getNome());
        System.out.printf(
                "Tranferencia Realizada para '%s' no valor de R$ %f",
                contaDestino.getTitular().getNome(), valor);
        System.out.println();
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Conta: %d | Titular: %s\n", numero, titular.getNome());
        System.out.printf("Saldo: %f\n", saldo);
        transacoes.forEach(transcacao -> {
        System.out.println(transcacao.getTipoTransacao() + " : " + transcacao);
        });
        System.out.println();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() { return titular; }

    public List<Transacao> getTransacoes() { return transacoes; }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", titular=" + titular.getNome() +
                '}';
    }
}
