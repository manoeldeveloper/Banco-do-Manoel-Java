package com.java.banco.mano;

public class Pessoa {

	protected String nome,sexo,cpf;
	
	private static int idUser = 1;

	protected Pessoa(String nome, String sexo, String cpf) {
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.getNome() + "\nSexo: " + this.getSexo() + "\nCPF: " + this.getCpf();
	}
	
	
	
	
}
