package reserva;

import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;

public final class Reserva {

	private Cliente cliente;
	private PessoaFisica fisica;
	private PessoaJuridica juridica;
	private boolean pagamentoAVista;

	public Reserva(Cliente cliente, boolean pagamentoAVista) {
		this.cliente = cliente;
		this.pagamentoAVista = pagamentoAVista;
	}

	public String toString() {
		String aux = "Nome: " + cliente.getNome();
		if (!pagamentoAVista) {
			aux += "\nPagamento: parcelado";
		} else {
			aux += "\nPagamento: à vista";
		}
		if (cliente instanceof PessoaFisica) {
			aux += "\nCliente: Pessoa Fisica";
		} else {
			aux += "\nCliente: Pessoa Jurídica";
		}
		return aux;
	}

	public double calcularPagamento() {
		if (pagamentoAVista) {
			return (3200.00 * 0.9);
		} else {
			return 3200.00;
		}
	}

	public PessoaFisica getFisica() {
		return fisica;
	}

	public PessoaJuridica getJuridica() {
		return juridica;
	}

}
