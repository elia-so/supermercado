package Servicos;

import java.util.List;

public class Venda {
	private List<Compra> compras;
	private int codigoVenda;

	public Venda(List<Compra> compras, int codigoVenda) {
		this.setCompras(compras);
		this.setCodigoVenda(codigoVenda);;
	}
	
	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}
