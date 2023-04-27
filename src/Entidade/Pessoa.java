package Entidade;

//CLASSE QUE PASSA A HERANÇA PARA AS CLASSES CLIENTE E VENDEDOR
public class Pessoa {
	private String nome;
	private int idade;
	private int senha;

//GETTERS E SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	//VERIFICA SE A SENHA DIGITADA É A MESMA QUE FOI INSERIDA NO ARRAYLIST DO MAIN
    public boolean autenticar(int senha, String nome) {
        if (this.senha == senha && this.nome == nome) {
            System.out.println("Acesso Permitido!");
            return true;
        } else {
            System.out.println("Acesso Negado!");
            return false;
        }
    }
}
