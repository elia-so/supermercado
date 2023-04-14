public class Cliente {
   private String nome;
   private String cpf;
   private String endereco;

   public Cliente(String nome, String cpf, String endereco) {
      this.nome = nome;
      this.cpf = cpf;
      this.endereco = endereco;
   }

   // getters e setters para os atributos

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCpf() {
      return cpf;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }

   public String getEndereco() {
      return endereco;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }
}
