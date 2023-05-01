package Servicos;
import br.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import Entidade.*;

// CONSTRUTOR DA CLASSE MERCADO
public class Mercado {
	private List<Cliente> clientes;
	private List<Vendedor> vendedores;
	private List<Produto> produtos;
	
	//CONSTRUTOR DA CLASSE QUE RECEBE A LISTA DE CLIENTES
	public Mercado(List<Cliente> clientes, List<Vendedor> vendedores, List<Produto> produtos) {
		this.clientes = clientes;
		this.vendedores = vendedores;
		this.produtos = produtos;
	}
	
	//CADASTRAR CLIENTES
	public void setClientes() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("bem-vindo ao cadastro de cliente\n");
		System.out.print("Digite o seu cpf: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Digite o seu nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite o seu email: ");
		String email = scanner.nextLine();
		
		System.out.print("Digite sua senha: ");
		String senha  = scanner.nextLine();
		
		System.out.print("Digite seu saldo: ");
		double saldo = scanner.nextDouble();
		
		Cliente c1 = new Cliente(nome, senha, email, saldo, cpf);
		clientes.add(c1);
		System.out.println("\nCliente cadastrado com sucesso!\n");
	}
	
	//IMPRIME OS CLIENTES NA TELA, MAS SO DEVE SER IMPRESSO SE TIVER LOGADO COMO VENDEDOR (SERÁ IMPLEMENTADO)
	public void getClientes() {	
		System.out.println("\t\t\t\tCLIENTES");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|\tCPF\t\t|\tNOME\t\t|\tSALDO\t\t|\tEMAIL\t\t|");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		for(int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			System.out.printf("|\t%-13s\t|\t%-13s\t|\t%-13s\t|%-13s\t|\n",c.getCpf(), c.getNome(), c.getSaldo(), c.getEmail());
		}
		System.out.println("+-----------------------------------------------------------------------------------------------+");
	}
	
	//CADASTRO DE VENDEDORES
	public void setVendedores() {
		Scanner scanner = new Scanner(System.in);
		Random codvendedor = new Random();
		System.out.println("bem-vindo ao cadastro de funcionario");
		System.out.print("Digite o seu nome: ");
		String nome = scanner.nextLine();
		
		System.out.print("Digite seu email: ");
		String email  = scanner.nextLine();
		
		System.out.print("Digite sua senha: ");
		String senha  = scanner.nextLine();
		
		Vendedor v1 = new Vendedor(nome, senha, email);
		int codigo = codvendedor.nextInt(100);
		if(codigo != v1.getCodigoVendedor()) {
			v1.setCodigoVendedor(codigo);
		} else {
			codigo = codvendedor.nextInt(100);
		}
		
		vendedores.add(v1);
		System.out.println("funcionario cadastrado com sucesso! \n");
	}
	// IMPRIME O ARRAYLIST DE VENDEDORES
	public void getVendedores() {	
		System.out.println("\t\t\t\tVENDEDORES");
		System.out.println("+---------------------------------------------------------------------------------------+");
		System.out.println("|\tCOD\t\t|\tNOME\t\t|\tEMAIL\t\t|");
		System.out.println("+---------------------------------------------------------------------------------------+");
		for(int i = 0; i < vendedores.size(); i++) {
			Vendedor v = vendedores.get(i);
			System.out.printf("|\t%d\t|\t%-13s\t|\t%-13s\t|\n",v.getCodigoVendedor(), v.getNome(), v.getEmail());
		}
		System.out.println("+---------------------------------------------------------------------------------------+");
	}
	// VERIFICA SE OS PARAMETROS SAO IGUAIS AOS DO ARRAYLIST
	public static boolean autenticarCliente(String nome, String senha, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
	// VERIFICA SE OS PARAMETROS SAO IGUAIS AOS DO ARRAYLIST
	public static boolean autenticarFuncionario(String nome, String senha, List<Vendedor> vendedores) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNome().equals(nome) && vendedor.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
	
	//TELA DE LOGIN PRINCIPAL
	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("VOCE E: \n");
		System.out.println("[1] Cliente");
		System.out.println("[2] vendedor");
		System.out.println("[3] voltar");
		String op = scanner.nextLine();
			switch(op) {
			case "1":
		        if(this.loginCliente()) {
		        	this.menuCliente();
		        } else {
		        	this.login();
		        }
		        break;
			case "2":
				if(this.loginVendedor()) {
					this.menuVendedor();
				} else {
					this.login();
				}
				break;
			case "3":
				this.menu();
				return false;
			default:
				break;
			}
		return true;
	}
	
	// TELA DE LOGIN DO CLIENTE
	public boolean loginCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite seu nome de usuario: ");
        String nome = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();
        if (Mercado.autenticarCliente(nome, senha, clientes)) {
            System.out.println("Bem-vindo, " + nome + "!");
            return true;
        } else {
            System.out.println("Nome de usuario ou senha invalidos.");
            return false;
        }
	}
	// TELA DE LOGIN DO VENDEDOR
	public boolean loginVendedor() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite seu nome de usuario: ");
        String nome = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();
        if (Mercado.autenticarFuncionario(nome, senha, vendedores)) {
            System.out.println("Bem-vindo, " + nome + "!");
            return true;
        } else {
            System.out.println("Nome de usuario ou senha invalidos.");
            return false;
        }
	}
	// MENU QUE APARECE PARA O CLIENTE APOS LOGIN
	void menuCliente() {
		
	}
	// MENU QUE APARCE PARA O VENDEDOR APOS O LOGIN
	void menuVendedor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1] Consultar clientes");
		System.out.println("[2] Cadastrar produtos");
		System.out.println("[3] Fazer venda");
		System.out.println("[4] logout");
		System.out.println("[5] encerrar programa");
		System.out.println("Selecione qual opcao deseja usar:");
		String option = scanner.nextLine();
		
		switch(option) {
		case "1":
			this.getClientes();
			this.menuVendedor();
			break;
		case "2":
			this.Cadastrarproduto();
			this.menuVendedor();
			break;
		case "3":
			
			break;
		case "4":
			System.out.println("sessao finalizada.");
			this.login();
			break;
		case "5":
			System.out.println("ate logo!");
			System.exit(0);
		default:
			break;
		}
	}
	// MENU INICIAL
	public boolean menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1] Cadastrar Cliente");
		System.out.println("[2] Cadastrar vendedor");
		System.out.println("[3] Fazer login");
		System.out.println("[4] sair");
		System.out.println("Selecione qual opcao deseja usar:");
		String option = scanner.nextLine();

		switch(option) {
		case "1":
			this.setClientes();
			break;
		case "2":
			this.setVendedores();
			break;
		case "3":
			this.login();
			break;
		case "4":
			System.out.println("Volte sempre");
			return false;
		default:
			break;
		}
		return true;
	}

	// MENU DE CADASTRAR PRODUTOS
	public void Cadastrarproduto() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1] Cadastrar novo produto");
		System.out.println("[2] Voltar");
		String option = scanner.nextLine();
		switch(option) {
			case "1":
				Random codproduto = new Random();
				System.out.println("Cadastro de produto\n");
				System.out.println("Digite o nome do produto:");
				String nome = scanner.nextLine();
				System.out.println("Digite a marca:");
				String marca = scanner.nextLine();
				System.out.println("Digite a quantidade:");
				int quantidade = scanner.nextInt();
				
				int codigoproduto = codproduto.nextInt(100);
				Produto pr1 = new Produto(nome, marca, quantidade, codigoproduto);
				
				if(codigoproduto == pr1.getCodigoProduto()) {
					pr1.setQuantidade(quantidade+1);
				}				
				produtos.add(pr1);
				System.out.println("produto cadastrado!");
				break;
			case "2":
				
				break;
		}
	}

	// CONSULTAR PRODUTOS
	public void getProdutos() {	
		System.out.println("\t\t\t\tprodutos");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|\tNOME\t\t|\t\tMarca\t|\t\tCodigo\t|");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		//List<Produto> produtos = new ArrayList<>();
		for(int i = 0; i < produtos .size(); i++) {
			Produto p = produtos.get(i);
			System.out.printf("|\t%-13s\t|\t%-13s\t|\t%-13s\t|\n",p.getNome(), p.getMarca(), p.getCodigoProduto());
		}
		System.out.println("+-----------------------------------------------------------------------------------------------+");
	}
	
}




