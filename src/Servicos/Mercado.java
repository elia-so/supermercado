package Servicos;
import br.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import Entidade.Cliente;
import Entidade.Pessoa;

public class Mercado {
	private List<Cliente> clientes;
	List<Produto> produtos = new ArrayList<>();
	
	//CONSTRUTOR DA CLASSE QUE RECEBE A LISTA DE CLIENTES
	public Mercado(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//FUNÇÃO PARA VERIFICAR LOGIN
	public void login() {
		System.out.println("Digite qual das opções deseja: \n");
		System.out.println("1-Cliente");
		System.out.println("2-funcionário");
	}
	
	//IMPRIME OS CLIENTES NA TELA, MAS SO DEVE SER IMPRESSO SE TIVER LOGADO COMO VENDEDOR (SERÁ IMPLEMENTADO)
	public void getClientes() {	
		System.out.println("\t\t\t\tCLIENTES");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		System.out.println("|\tCPF\t\t|\tNOME\t\t|\tSaldo\t\t|\tEMAIL\t\t|");
		System.out.println("+-----------------------------------------------------------------------------------------------+");
		for(int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			System.out.printf("|\t%-13s\t|\t%-13s\t|\t%-13s\t|%-13s\t|\n",c.getCpf(), c.getNome(), c.getSaldo(), c.getEmail());
		}
		System.out.println("+-----------------------------------------------------------------------------------------------+");
	}
	
	public void Cadastrarproduto() {
		//List<Produto> produtos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("[1] Cadastrar novo produto:");
			System.out.println("[2] Sair:");
			String option = scanner.nextLine();
			switch(option) {
			case "1": {
				System.out.println("Cadastro de produto:");
				System.out.println("Digite o nome do produto:");
				String nome = scanner.nextLine();
				System.out.println("Digite a marca:");
				String marca = scanner.nextLine();
				System.out.println("Digite o código do produto:");
				String codigo = scanner.nextLine();
				Produto pr1 = new Produto();
				pr1.setNome(nome);
				pr1.setMarca(marca);
				pr1.setCodigoProduto(codigo);
				produtos.add(pr1);
				System.out.println("produto cadastrado!");
				break;
			    }
			case "2": {
				loop = false;
				break;
			}
		    }
		  }
		}
	
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




