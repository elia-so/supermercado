package Interface;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Classe.Cliente;
import Classe.Produto;
import Classe.Vendedor;
import Repositorio.*;
import Teste.*;

import java.util.ArrayList;

// CONSTRUTOR DA CLASSE MERCADO
public class Mercado {
	private List<Cliente> clientes;
	private List<Vendedor> vendedores;
	private List<Produto> produtos;
	private List<Compra> compras;
	//CONSTRUTOR DA CLASSE QUE RECEBE A LISTA DE CLIENTES
	public Mercado(List<Cliente> clientes, List<Vendedor> vendedores, List<Produto> produtos, List<Compra> compras) {
		this.clientes = clientes;
		this.vendedores = vendedores;
		this.produtos = produtos;
		this.compras = compras;
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
	// VERIFICA SE OS PARAMETROS SAO IGUAIS AO DO ARRAYLIST
	public static boolean autenticarProduto(String nome, String marca, int quantidade, List<Produto> produtos) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome) && produto.getMarca().equals(marca)) {
            	int novaquantidade = produto.getQuantidade();
            	produto.setQuantidade(novaquantidade + quantidade);
            	return true;
            }
        }
        return false;
    }
	public static boolean autenticarCompra(String nome, String marca, int quantidade, List<Compra> compras) {
        for (Compra compra : compras) {
            if (compra.getNome().equals(nome) && compra.getMarca().equals(marca)) {
            	int novaquantidade = compra.getQuantidade();
            	compra.setQuantidade(novaquantidade + quantidade);
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
	String nomec, senhac;
	public boolean loginCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite seu nome de usuario: ");
        String nome = scanner.next();
        System.out.print("Digite sua senha: ");
        String senha = scanner.next();
        if (Mercado.autenticarCliente(nome, senha, clientes)) {
            nomec = nome;
            senhac = senha;
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
            nomec = nome;
            senhac = senha;
            System.out.println("Bem-vindo, " + nome + "!");
            return true;
        } else {
            System.out.println("Nome de usuario ou senha invalidos.");
            return false;
        }
    
	}
	// MENU QUE APARECE PARA O CLIENTE APOS LOGIN
	void menuCliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1] Consultar meus dados");
		System.out.println("[2] Comprar produtos");
		System.out.println("[3] Comprovante de compra");
		System.out.println("[4] Consultar produtos");
		System.out.println("[5] logout");
		System.out.println("[6] encerrar programa");
		System.out.println("[7] editar conta");
		System.out.println("[8] excluir conta");
		System.out.println("Selecione qual opcao deseja usar:");
		String option = scanner.nextLine();
		
		switch(option) {
		case "1":
			for(Cliente cliente : clientes) {
				if(cliente.getNome().equals(nomec) && cliente.getSenha().equals(senhac)) {
					cliente.consultaDados();
				}
			}
			this.menuCliente();
			break;
		case "2":
			compras = this.menuComprar();
			this.menuCliente();
			break;
		case "3":
			this.listaCompras();
			this.menuCliente();
			break;
		case "4":
			this.getProdutos();
			this.menuCliente();
			break;
		case "5":
			System.out.println("sessao finalizada.");
			this.login();
			break;
		case "6":
			System.out.println("ate logo!");
			System.exit(0);
		case "7":
			this.editarCliente();
			this.login();
			break;
		case "8":
			this.apagarcliente();
			this.login();
			break;
		default:
			break;
		}
	}
	// IMPRIME A LISTA DE COMPRAS
	double totalCompra = 0;
	public void listaCompras() {	
		System.out.println("\t\t\t\tLISTA");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|\tNOME\t\t|\tMARCA\t\t|\tCOD\t|\tQTD\t|\tPRECO\t|");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		for(int i = 0; i < compras.size(); i++) {
			Compra p = compras.get(i);
			System.out.printf("|\t%-13s\t|\t%-13s\t|\t%d\t|\t%d\t|%-13s|\n",p.getNome(), p.getMarca(), p.getCodigoProduto(), p.getQuantidade(), p.getPreco());
			totalCompra += (p.getPreco() * p.getQuantidade());
		}
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.printf("\t\t\t\t\t\t\t\tTOTAL A PAGAR: %.2f\n", totalCompra);
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		totalCompra = 0;
	}
	
	// MENU QUE APARCE PARA O VENDEDOR APOS O LOGIN
	void menuVendedor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[1] Consultar clientes");
		System.out.println("[2] Cadastrar produtos");
		System.out.println("[3] Consultar produtos");
		System.out.println("[4] logout");
		System.out.println("[5] consultar dados");
		System.out.println("[6] editar dados");
		System.out.println("[7] encerrar programa");
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
			this.getProdutos();
			this.menuVendedor();
			break;
		case "4":
			System.out.println("sessao finalizada.");
			this.login();
			break;
		case "5":
			for(Vendedor vendedor : vendedores) {
				if(vendedor.getNome().equals(nomec) && vendedor.getSenha().equals(senhac)) {
					vendedor.consultaDados();
				}
			}
			this.menuVendedor();
			break;
		case "6":
			this.editarVendedor();
			this.login();
			break;
		case "7":
			System.out.println("ate logo!");
			System.exit(0);
			break;
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
			System.exit(0);
			return false;
		default:
			break;
		}
		return true;
	}

	public List<Compra> menuComprar() {
		List<Compra> compras = new ArrayList<>();
	    Scanner scanner = new Scanner(System.in);
	    String resposta = "s";
	    while(resposta.equalsIgnoreCase("s")) {
	    	System.out.println("Escolha um produto para comprar:\n");
	    	for(int i = 0; i < produtos.size(); i++) {
	    		System.out.println((i+1) + ". " + produtos.get(i).getNome() + " | R$" + produtos.get(i).getPreco());
	    	}
	    	int opcao = scanner.nextInt();
	    	
	    	if(Mercado.autenticarCompra(produtos.get(opcao-1).getNome(), produtos.get(opcao-1).getMarca(), 1, compras)) {
				
			} else {
				Compra compra = new Compra(produtos.get(opcao-1).getNome(), produtos.get(opcao-1).getMarca(), 1, produtos.get(opcao-1).getCodigoProduto(), produtos.get(opcao-1).getPreco());
				compras.add(compra);
			}
	    	
	    	int qtd = produtos.get(opcao-1).getQuantidade();
	    	produtos.get(opcao-1).setQuantidade(qtd-1);
	    	System.out.println("Deseja continuar comprando? (S/N)");
            resposta = scanner.next();
	    }
	    for(int i = 0; i < compras.size(); i++) {
			Compra p = compras.get(i);
			totalCompra += (p.getPreco() * p.getQuantidade());
		}
	    double novoSaldo;
		for(Cliente cliente : clientes) {
			if(cliente.getNome().equals(nomec) && cliente.getSenha().equals(senhac)) {
				novoSaldo = cliente.getSaldo();
				cliente.setSaldo(novoSaldo - totalCompra);
				totalCompra = 0;
			}
		}
	    return compras;
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
				System.out.println("Digite o preco:");
				double preco = scanner.nextInt();
				
				int codigoproduto = codproduto.nextInt(100);
				if(Mercado.autenticarProduto(nome, marca, quantidade, produtos)) {
					break;
				} else {
					Produto pr1 = new Produto(nome, marca, quantidade, codigoproduto, preco);
					produtos.add(pr1);
				}
				System.out.println("produto cadastrado!");
				break;
			case "2":
				this.menuVendedor();
				break;
		}
	}

	// CONSULTAR PRODUTOS
	public void getProdutos() {	
		System.out.println("\t\t\t\tprodutos");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|\tNOME\t\t|\tMARCA\t\t|\tCOD\t|\tQTD\t|\tPRECO\t|");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		//List<Produto> produtos = new ArrayList<>();
		for(int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			System.out.printf("|\t%-13s\t|\t%-13s\t|\t%d\t|\t%d\t|\t%-13s|\n",p.getNome(), p.getMarca(), p.getCodigoProduto(), p.getQuantidade(), p.getPreco());
		}
		System.out.println("+-----------------------------------------------------------------------------------------------+");
	}
	
	public void apagarcliente() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("tem certeza que deseja APAGAR?");
		System.out.println("Digite sua senha:");
		String senha = scanner.nextLine();
		int position = 0;
		for(int i = 0; i < clientes.size(); i++) {
			Cliente c1 = clientes.get(i);
			if(senhac.equals(senha)) {
			if(c1.getNome().equals(nomec) && c1.getSenha().equals(senhac)) {
				position = i;
				clientes.remove(position);
			}
		}
		}
		
	}
	
	public void editarCliente () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite sua senha pra prosseguir:");
		String senha = scanner.nextLine();
		int position = 0;
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getSenha().equals(senha)) {
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
				double novo_saldo = clientes.get(position).getSaldo();
				clientes.get(position).setCpf(cpf);
				clientes.get(position).setEmail(email);
				clientes.get(position).setNome(nome);
				clientes.get(position).setSaldo(novo_saldo+saldo);
				clientes.get(position).setSenha(senhas);
			} else {
				System.out.print("senha incorreta! Digite novamente \n");
				senha = scanner.nextLine();
			}
		}
		}
		
		public void editarVendedor() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite sua senha pra prosseguir:");
			String senha = scanner.nextLine();
			int position = 0;
			for(int i = 0; i < vendedores.size(); i++) {
				if(vendedores.get(i).getSenha().equals(senha)) {
					position = i;
					
					System.out.print("Digite o seu nome: ");
					String nome = scanner.nextLine();
					
					System.out.print("Digite o seu email: ");
					String email = scanner.nextLine();
					
					System.out.print("Digite sua senha: ");
					String senhas  = scanner.nextLine();
					
					vendedores.get(position).setEmail(email);
					vendedores.get(position).setNome(nome);
					vendedores.get(position).setSenha(senhas);
				} else {
					System.out.print("senha incorreta!Digite novamente \n");
					senha = scanner.nextLine();
				}
			}
	}
}




