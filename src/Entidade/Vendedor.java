package Entidade;

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
}
