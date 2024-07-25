package sef.module4.activity;

public class PrincipalContaCorrente {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Raphael", "Agra", "111.111.111-11");
		ContaCorrente conta1 = new ContaCorrente("001", cliente1);
		System.out.println("Saldo da conta 1: R$ " + conta1.getSaldo());
		
		// Exibir o nome do cliente da conta1
        System.out.println("Cliente da Conta 1: " + conta1.getCliente().getNome());
		
		conta1.depositar(100);
		System.out.println("\nSaldo da conta 1: R$ " + conta1.getSaldo());
		
		conta1.sacar(50);
		System.out.println("Saldo da conta 1: R$ " + conta1.getSaldo());
		
		// Tentativa de saque invalido
		conta1.sacar(51);
		System.out.println("Saldo da conta 1: R$ " + conta1.getSaldo());
		
		// Tentativa de saque invalido
		conta1.sacar(-1);
		System.out.println("Saldo da conta 1: R$ " + conta1.getSaldo() + "\n");
		
		
		Cliente cliente2 = new Cliente("Joao", "Luena", "222.222.222-22");
		ContaCorrente conta2 = new ContaCorrente("002", cliente2);
		System.out.println("\nSaldo da conta 2: R$ " + conta2.getSaldo());
		
		// Exibir o nome do cliente da conta2
        System.out.println("Cliente da Conta 2: " + conta2.getCliente().getNome() + "\n");

		// Transferencia da conta1 para conta2
        conta1.transferir(conta2, 10.00);
        System.out.println("Saldo da conta 1: R$ " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: R$ " + conta2.getSaldo());
        
        // Tentar transferir um valor que deixaria a conta1 negativa
        conta1.transferir(conta2, 50.00);
        System.out.println("\nSaldo da conta 1: R$ " + conta1.getSaldo());
        System.out.println("Saldo da conta 2: R$ " + conta2.getSaldo());
        
		// Exibir extrato da conta1
		System.out.println(conta1.exibirExtrato());
		
		// Exibir extrato da conta2
		System.out.println(conta2.exibirExtrato());
	}

}
