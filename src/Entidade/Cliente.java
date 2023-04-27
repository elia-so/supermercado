package Entidade;

//CLASSE HERDA AS VARIAVEIS DE PESSOA
public class Cliente extends Pessoa{
	private String cpf;
	private String email;
	private double saldo;

// GETTERS E SETTERS
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
