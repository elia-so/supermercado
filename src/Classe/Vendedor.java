package Classe;

import java.util.Scanner;

import Interface.Mercado;

//CLASSE HERDA AS VARIAVEIS DE PESSOA
public class Vendedor extends Pessoa{
	private int codigoVendedor;
	
	public Vendedor(String nome, String senha, String Email) {
		super(nome, senha, Email);
	}
	
	public int getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	
	// MÉTODOS
	@Override
	public void consultaDados() {
		System.out.printf("Codigo: %-13s\n", this.getCodigoVendedor());
		System.out.printf("Nome: %-13s\n", this.getNome());
		System.out.printf("Email: %-13s\n", this.getEmail());
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
		for(int i = 0; i < Mercado.getvendedores().size(); i++) {
			if(Mercado.getvendedores().get(i).getSenha().equals(senha)) {
				position = i;
				
				System.out.print("Digite o seu nome: ");
				String nome = scanner.nextLine();
				
				System.out.print("Digite o seu email: ");
				String email = scanner.nextLine();
				
				System.out.print("Digite sua senha: ");
				String senhas  = scanner.nextLine();
				
				Mercado.getvendedores().get(position).setEmail(email);
				Mercado.getvendedores().get(position).setNome(nome);
				Mercado.getvendedores().get(position).setSenha(senhas);
			} else {
				System.out.print("senha incorreta!Digite novamente \n");
				senha = scanner.nextLine();
			}
		}
}
}
