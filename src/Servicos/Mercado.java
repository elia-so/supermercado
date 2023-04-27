package Servicos;

import java.util.List;

import Entidade.Cliente;

public class Mercado {
	private List<Cliente> clientes;
	
	//CONSTRUTOR DA CLASSE QUE RECEBE A LISTA DE CLIENTES
	public Mercado(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	//FUNÇÃO PARA VERIFICAR LOGIN
	public void login() {
		
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
}
