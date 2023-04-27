package Entidade;

//CLASSE HERDA AS VARIAVEIS DE PESSOA
public class Vendedor extends Pessoa{
	private int codigoVendedor;
	private String Email;

	//POR ENQUANTO SEM UTILIDADE
	public int getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}

}
