package main.java.bank.transacao;

import main.java.bank.conta.Conta;

public class Transferencia extends Transacao {
    private final Conta contaDestino;

    public Transferencia(double valor, Conta conta, Conta contaDestino) {
        super(valor, conta, TipoTransacao.TRASFERENCIA);
        this.contaDestino = contaDestino;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    @Override
    public String toString() {
        return  "{" +
                " data=" +
                ", contaDestino=" + contaDestino.getTitular().getNome() +
                ", " + data +
                ", tipoTransacao=" + tipoTransacao +
                ", valor=" + valor +
                '}';
    }
}
