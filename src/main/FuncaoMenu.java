package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;
import reserva.Reserva;

public class FuncaoMenu {

	public int menu() {
		int opcao;
		String aux = "Restaurante SABOR SOFISTICADO \n1.Reservar mesa \n2.Pesquisar reserva \n3.Imprimir reservas \n4.Imprimir lista de espera \n5.Cancelar reserva \n6.Finalizar  ";
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null, aux, "Entrada", JOptionPane.QUESTION_MESSAGE));

		while (opcao > 6 || opcao < 1) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, aux, "Entrada", JOptionPane.ERROR_MESSAGE));
		}
		return opcao;
	}

	public Reserva opcao1() {
		// variaveis
		String nome, cpf, cnpj;
		int resposta;
		boolean pagamentoAVista;
		String[] cadastroPessoa = { "Cpf", "Cnpj" };
		String[] pagamento = { "À vista", "Parcelado" };
		Reserva reservaCliente;

		// nome
		nome = JOptionPane.showInputDialog("Nome da reserva");

		// metodo de pagamento
		resposta = JOptionPane.showOptionDialog(null, "Escolha o método de pagamento", "Pagamento",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pagamento, pagamento[0]);

		if (resposta == 0) {
			pagamentoAVista = true;
		} else {
			pagamentoAVista = false;
		}

		// cpf ou cnpj
		resposta = JOptionPane.showOptionDialog(null, "Escolha sua preferencia de cadastro", "Cadastro",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, cadastroPessoa, cadastroPessoa[0]);

		if (resposta == 0) {
			cpf = JOptionPane.showInputDialog("Digite seu cpf");
			PessoaFisica cliente = new PessoaFisica(nome, cpf);
			reservaCliente = new Reserva(cliente, pagamentoAVista);
		} else {
			cnpj = JOptionPane.showInputDialog("Digite seu cnpj");
			PessoaJuridica cliente = new PessoaJuridica(nome, cnpj);
			reservaCliente = new Reserva(cliente, pagamentoAVista);
		}

		return reservaCliente;
	}

	public String opcao2(ArrayList<Reserva> reserva, ArrayList<Reserva> listaEspera) {
		String resposta = null;
		String busca = JOptionPane.showInputDialog("Digite seu Cpf/Cnpj");
		for (int i = 0; i < listaEspera.size(); i++) {
			if (reserva.get(i).getFisica().getCpf().equalsIgnoreCase(busca) || reserva.get(i).getJuridica().getCnpj().equalsIgnoreCase(busca)) {
				resposta = "Você tem uma reserva para 29/05/2021";
			} else {
				if (listaEspera.get(i).getFisica().getCpf().equalsIgnoreCase(busca)	|| listaEspera.get(i).getJuridica().getCnpj() == busca) {
					resposta = "Você está em " + listaEspera.size() + "º na fila de espera";
				}else {
					resposta = "Você não tem uma reserva para esse restaurante";
				}
			}

		}

		return resposta;
	}
	
	
}
