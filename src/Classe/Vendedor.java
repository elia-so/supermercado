package Classe;

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
}
