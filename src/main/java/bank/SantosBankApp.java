package main.java.bank;

import main.java.bank.cliente.Cliente;
import main.java.bank.conta.Conta;
import main.java.bank.conta.ContaCorrente;
import main.java.bank.conta.ContaPoupanca;

public class SantosBankApp {
    public static void main(String[] args) {
        Cliente junior = new Cliente("junior");
        Cliente fred = new Cliente("fred");

        Conta contaJunior = new ContaCorrente(junior);
        Conta contaFred = new ContaPoupanca(fred);

        // Deposito Inicial
        contaJunior.depositar(1500);
        contaFred.depositar(2500);

        // Saque + Deposito
        contaJunior.sacar(350);
        contaJunior.sacar(35.65);
        contaJunior.sacar(99.50);

        contaFred.sacar(999.99);
        contaFred.sacar(329);

        contaJunior.imprimirExtrato();
        contaFred.imprimirExtrato();

        // Transferencias
        contaJunior.transferir(50, contaFred);
        contaJunior.transferir(150, contaFred);
        contaFred.transferir(20, contaJunior);

        System.out.println();

        //Extrato
        contaJunior.imprimirExtrato();
        contaFred.imprimirExtrato();

        // Saldo Insuficiente
        contaJunior.sacar(2000);
        System.out.println();
        contaFred.transferir(3000, contaJunior);
        System.out.println();

        System.out.printf("Saldo Junior: %f\n", contaJunior.getSaldo());
        System.out.printf("Saldo Fred: %f", contaFred.getSaldo());
    }
}
