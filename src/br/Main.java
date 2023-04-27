package br;
import java.util.ArrayList;
import java.util.List;

import Entidade.*;
import Servicos.*;

public class Main {
	public static void main(String[] args) {
		
		//ATRIBUINDO VALORES PARA OS 3 OBJETOS CRIADOS DO TIPO CLIENTE
		Cliente c1 = new Cliente();
		c1.setNome("cuzinho");
		c1.setEmail("cuzinho@gmail.com");
		c1.setIdade(21);
		c1.setCpf("55544433321");
		c1.setSaldo(1209.69);
		c1.setSenha(123);
		
		Cliente c2 = new Cliente();
		c2.setNome("elias");
		c2.setEmail("elias@gmail.com");
		c2.setIdade(22);
		c2.setCpf("11144433321");
		c2.setSaldo(809.69);
		c2.setSenha(321);
		
		Cliente c3 = new Cliente();
		c3.setNome("rayssa");
		c3.setEmail("rayssaszz@gmail.com");
		c3.setIdade(19);
		c3.setCpf("55566633321");
		c3.setSaldo(149.69);
		c3.setSenha(123);
		
		//ATRIBUINDO OS CLIENTES CRIADOS AO ARRAYLIST
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		
		//CRIAÇÃO DE UM VENDEDOR POR ENQUANTO SEM USO
		Vendedor v1 = new Vendedor();
		v1.setNome("admin");
		v1.setSenha(123456);
		boolean login = v1.autenticar(123456, "admin");
		
		//AINDA TERA UMA INTERFACE DE LOGIN PARA ESSE IF ABAIXO REALMENTE FUNCIONAR (A FUNCAO login() QUE SE ENCONTRA NA CLASSE MERCADO)
		if(login == false) {
			System.out.println("Não foi possível acessar o sistema.");
		} else {
			Mercado padrecicero = new Mercado(clientes);
			padrecicero.getClientes();
		}
	}
}
