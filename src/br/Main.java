package br;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entidade.*;
import Servicos.*;
// Para cadastrar produto basta selecionar 4 e outro menu será aberto

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Pessoa> Pessoas = new ArrayList<>();
		//loop para menu de seleção
		boolean loop = true;
		while(loop) {
			System.out.println("[1] Cadastrar Cliente");
			System.out.println("[2] Cadastrar vendedor");
			System.out.println("[3] Fazer login");
			System.out.println("[4] sair");
			System.out.println("Selecione qual opcao deseja usar:");
			String option = scanner.nextLine();
			
			switch(option) {
			case "1": {
				System.out.println("bem-vindo ao cadastro de cliente:");
				System.out.println("Digite o seu nome:");
				String nome = scanner.nextLine();
				System.out.println("Digite sua senha:");
				int senha  = scanner.nextInt();
				Pessoa p1 = new Pessoa();
				p1.setNome(nome);
				p1.setSenha(senha);
				Pessoas.add(p1);
				System.out.println("Cliente cadastrado com sucesso!");
				break;
			}
			case "2": {
				System.out.println("bem-vindo ao cadastro de funcionario:");
				System.out.println("Digite o seu Email:");
				String email = scanner.nextLine();
				System.out.println("Digite seu código de vendedor:");
				int codigoVendedor  = scanner.nextInt();
				Pessoa p2 = new Pessoa();
				p2.setEmail(email);
				p2.setCodigoVendedor(codigoVendedor);
				Pessoas.add(p2);
				System.out.println("funcionario cadastrado com sucesso! \n");
				break;
			}
			case "3": {
				break;
			}
			case "4": {
				loop = false;
				System.out.println("Volte sempre");
				break;
			}
			}
		}

		List<Cliente> clientes = new ArrayList<>();
		Mercado padrecicero = new Mercado(clientes);
		//CRIAÇÃO DE UM VENDEDOR POR ENQUANTO SEM USO
		/*Vendedor v1 = new Vendedor();
		v1.setNome("admin");
		v1.setSenha(123456);
		boolean login = v1.autenticar(123456, "admin");
		
		//AINDA TERA UMA INTERFACE DE LOGIN PARA ESSE IF ABAIXO REALMENTE FUNCIONAR (A FUNCAO login() QUE SE ENCONTRA NA CLASSE MERCADO)
		if(login == false) {
			System.out.println("Não foi possível acessar o sistema.");
		} else {
			padrecicero.getClientes();
		}*/
		
		padrecicero.Cadastrarproduto();
		padrecicero.getProdutos();
	}
}
