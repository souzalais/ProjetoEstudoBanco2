package utils;

public class Pessoa {

	private long cpf;
	private String nome;
	private int idade;
	private long rg;
	
	public Pessoa() {
		super();
	}

	public Pessoa(long cpf, String nome, int idade, long rg) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.rg = rg;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

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

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", rg=" + rg + "]";
	}
	
	
	
	
}
