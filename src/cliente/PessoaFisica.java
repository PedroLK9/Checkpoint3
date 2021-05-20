package cliente;

public final class PessoaFisica extends Cliente {

	String cpf;

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	public String toString() {
		String aux = super.toString();
		aux += "CPF:" + cpf;
		return aux;
	}

	public String getCpf() {
		return cpf;
	}

}
