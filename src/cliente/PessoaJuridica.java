package cliente;

public final class PessoaJuridica extends Cliente {

	String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public String toString() {
		String aux = super.toString();
		aux += "CNPJ:" + cnpj;
		return aux;
	}

	public String getCnpj() {
		return cnpj;
	}

}
