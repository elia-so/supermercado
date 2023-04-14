import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
   private Date data;
   private List<Produto> produtos;
   private Cliente cliente;
   private double valorTotal;

   public Venda(Date data, List<Produto> produtos, Cliente cliente) {
      this.data = data;
      this.produtos = produtos;
      this.cliente = cliente;
      this.valorTotal = calcularValorTotal();
   }

   // getters e setters para os atributos

   public Date getData() {
      return data;
   }

   public void setData(Date data) {
      this.data = data;
   }

   public List<Produto> getProdutos() {
      return produtos;
   }

   public void setProdutos(List<Produto> produtos) {
      this.produtos = produtos;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public double getValorTotal() {
      return valorTotal;
   }

   public void setValorTotal(double valorTotal) {
      this.valorTotal = valorTotal;
   }

   // método para calcular o valor total da venda

  
