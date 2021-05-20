package cliente;

public abstract class Cliente {

	protected String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String toString() {
		String aux = "Nome:" + nome;
		return aux;
	}

	public String getNome() {
		return nome;
	}

	
}
