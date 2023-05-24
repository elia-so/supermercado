package Classe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Interface.*;
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
	
	@Override
	public void editarDados(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite sua senha pra prosseguir:");
		String senha = scanner.nextLine();
		int position = 0;
		for(int i = 0; i < Mercado.getclientes().size(); i++) {
			if(Mercado.getclientes().get(i).getSenha().equals(senha)) {
				position = i;
				System.out.print("Digite o seu cpf: ");
				String cpf = scanner.nextLine();
				
				System.out.print("Digite o seu nome: ");
				String nome = scanner.nextLine();
				
				System.out.print("Digite o seu email: ");
				String email = scanner.nextLine();
				
				System.out.print("Digite sua senha: ");
				String senhas  = scanner.nextLine();
				
				System.out.print("Digite a quantidade de saldo que deseja adicionar:");
				double saldo = scanner.nextDouble();
				double novo_saldo = Mercado.getclientes().get(position).getSaldo();
				Mercado.getclientes().get(position).setCpf(cpf);
				Mercado.getclientes().get(position).setEmail(email);
				Mercado.getclientes().get(position).setNome(nome);
				Mercado.getclientes().get(position).setSaldo(novo_saldo+saldo);
				Mercado.getclientes().get(position).setSenha(senhas);
			} else {
				System.out.print("senha incorreta! Digite novamente \n");
				senha = scanner.nextLine();
			}
		}
		}
}
