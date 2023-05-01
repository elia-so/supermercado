package Entidade;

//CLASSE HERDA AS VARIAVEIS DE PESSOA
public class Cliente extends Pessoa{
	private double saldo;
	private String cpf;

	
	//método que herda os dados da classe mãe
	public Cliente(String nome, String senha, String Email, double saldo, String cpf) {
		super(nome, senha, Email);
		this.setSaldo(saldo);
		this.setCpf(cpf);
	}
	
// GETTERS E SETTERS

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
