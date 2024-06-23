# Sistema Bancário em Java

Este projeto é um sistema bancário desenvolvido em Java, focado em treinar conceitos de orientação a objetos (OO). O sistema permite a criação e gestão de diferentes tipos de contas bancárias, como conta corrente e conta poupança. Além disso, o sistema implementa transações bancárias básicas como depósitos, saques e transferências entre contas.

## Funcionalidades
### Contas
- Conta: Permite operações de saques, depósitos, transferências e vizualização de extrato.
### Clientes
- Gestão de informações dos clientes.
### Transações
São objetos utilizados para armazenar os dados de transação gerados pelos metodos da classe Conta.
- **Transacao:** Utilizado armazenar dados de deposito e saque.
- **Transferencia:** Classe filha da **Transacao** porem tem o atributo 'contaDestino', utilizado para armazenar o destinatario de uma transferencia.

## Estrutura do projeto
    src/
    ├── bank/
    │   ├── SantosBankApp.java         # Classe principal para execução do programa
    │   ├── cliente/
    │   │   ├── Cliente.java
    │   ├── conta/
    │   │   ├── Conta.java         # Classe abstrata base para contas
    │   │   ├── ContaCorrente.java # Implementação de conta corrente
    │   │   ├── ContaPoupanca.java # Implementação de conta poupança
    │   │   └── IConta.java        # Interface da classe Conta
    │   └── transacao/
    │       ├── TipoTransacao.java   # Enum para tipo de transação (DEPOSITO, SAQUE, TRANSFERENCIA)
    │       ├── Transacao.java       # Classe utilizada para dados de transação
    │       └── Trasferencia.java    # Classe filha(Transacao) utilizada para dados de transferencia entre contas.
