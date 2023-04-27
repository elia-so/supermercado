package Entidade;

//CLASSE HERDA AS VARIAVEIS DE PESSOA
public class Cliente extends Pessoa{
	private String nome;
	private int senha;
	private double saldo;

// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}

	public void setCpf(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
