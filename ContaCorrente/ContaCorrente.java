package sef.module4.activity;

import java.util.Date;

public class ContaCorrente {

	private String numero;
	private double saldo;
	private Date data;
	private Cliente cliente;
	private StringBuilder extrato;
	
	public ContaCorrente(String numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0;
		this.data = new Date();
		this.extrato = new StringBuilder();
	}
	
	public ContaCorrente(String numero, Date data, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0;
		this.data = data;
		this.extrato = new StringBuilder();
	}
	
	public void depositar(double valorDeposito) {
		if (valorDeposito > 0) {
			this.saldo += valorDeposito;
			this.extrato.append(String.format("Depósito: R$%.2f em %s\n", valorDeposito, new Date().toString()));
		}
	}
	
	public void sacar(double valorSaque) {
		if (valorSaque > 0 && valorSaque <= this.saldo) {
			this.saldo -= valorSaque;
			this.extrato.append(String.format("Saque:    R$%.2f em %s\n", valorSaque, new Date().toString()));
		}
	}
	
	public void transferir(ContaCorrente contaDestino, double valorTransferencia) {
		if (valorTransferencia > 0 && valorTransferencia <= this.saldo) {
			this.saldo -= valorTransferencia;
			contaDestino.saldo += valorTransferencia;
			
			this.extrato.append(String.format("Transferência enviada: R$%.2f para Conta: %s em %s\n", valorTransferencia, contaDestino.getNumero(), new Date().toString()));
			contaDestino.getExtrato().append(String.format("Transferência recebida: R$%.2f de Conta: %s em %s\n", valorTransferencia, this.numero, new Date().toString()));

		}
	}
	
	public String exibirExtrato() {
		String template = String.format("EXTRATO BANCARIO\nConta: %s\nCliente: %s\n\n", numero, cliente.getNome());
		return template + this.extrato;
	}

	public String getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public StringBuilder getExtrato() {
		return extrato;
	}
	
}
