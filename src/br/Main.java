package br;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
import Entidade.*;
import Servicos.*;
// Para cadastrar produto basta selecionar 4 e outro menu será aberto


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<>();
		List<Vendedor> vendedores = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		Mercado padrecicero = new Mercado(clientes, vendedores, produtos);
		
		//loop para menu de seleção
		boolean loop = true;
		while(loop) {
			loop = padrecicero.menu();
		}


	}
}
