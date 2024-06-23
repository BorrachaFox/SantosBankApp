package main.java.bank.conta;

public interface IConta {
    void sacar(double valor);
    void sacar(double valor, boolean geraTransacao);
    void depositar(double valor);
    void depositar(double valor, boolean geraTransacao);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
}
