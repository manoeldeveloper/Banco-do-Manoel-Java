package com.java.banco.mano;
import com.java.banco.mano.Pessoa;
public class Conta {

	private static int idUser = 1;
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;
	
	protected Conta(Pessoa pessoa) {
		this.numeroConta = Conta.idUser;
		this.pessoa = pessoa; 
		this.saldoAtual();
		Conta.idUser += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	private void saldoAtual() {
		this.saldo = this.getSaldo();
	}
	@Override
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() + "\n" + this.pessoa + "\nSaldo: " + saldo;
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo = this.getSaldo() + valor;
			System.out.println("Valor Depositado com Sucesso!!");
		} else {
			System.out.println("Erro! Tente Novamente!");
		}
	}
	
	public void sacar(double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			System.out.println("Valor retirado com sucesso!");
		} else {
			System.out.println("Você não tem saldo, verifique o valor e tente novamente!");
		}
	}
	
	public void transferir(Conta contadepo, double valor) {
		if(valor > 0 && this.getSaldo() - valor >= 0) {
			this.saldo = this.getSaldo() - valor;
			contadepo.saldo = contadepo.getSaldo() + valor;
			System.out.println("Transferência realizada com sucesso!");
			} else {
				System.out.println("Erro! Tente novamente!");
			}
	}
	
}
