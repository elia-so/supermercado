package Classe;
import java.util.ArrayList;

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
	
	// MÉTODOS
	@Override
	public void consultaDados() {
		System.out.printf("CPF: %-13s\n", this.getCpf());
		System.out.printf("Nome: %-13s\n", this.getNome());
		System.out.printf("Email: %-13s\n", this.getEmail());
		System.out.printf("Saldo: %-13s\n", this.getSaldo());
		System.out.printf("Senha: %-13s\n\n", this.getSenha());
	}
	@Override
	public void setDados() {
		
	}
	
}
