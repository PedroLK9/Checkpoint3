package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import reserva.Reserva;

public class Principal {

	public static void main(String[] args) {

		int opcao;
		int i = 0;
		FuncaoMenu funcao = new FuncaoMenu();
		ArrayList<Reserva> reserva = new ArrayList<Reserva>();
		ArrayList<Reserva> listaEspera = new ArrayList<Reserva>();

		do {
			// menu
			opcao = funcao.menu();

			// resposta do menu
			switch (opcao) {
			case 1:
				if (reserva.size() < 5) {
					reserva.add(funcao.opcao1());
				} else {
					i++;
					listaEspera.add(funcao.opcao1());
					JOptionPane.showMessageDialog(null,
							"A lista de reservas foi excedida, você está na " + i + "º posição");
				}
				break;
			case 2:
				String resposta = funcao.opcao2(reserva, listaEspera);
				JOptionPane.showMessageDialog(null, resposta);
				break;
			case 3:
				for (int j = 0; j < reserva.size(); j++) {
					JOptionPane.showMessageDialog(null, funcao.opcao3(reserva.get(j)));
					;
				}
				break;
			case 4:
				for (int j = 0; j < listaEspera.size(); j++) {
					JOptionPane.showMessageDialog(null,
							funcao.opcao3(listaEspera.get(j)) + "\nPosição: " + (j + 1) + "º");
					;
				}
				break;

			default:
				JOptionPane.showMessageDialog(null, "Obrigado volte sempre", "Agradecimento",
						JOptionPane.INFORMATION_MESSAGE);

			}

		} while (opcao != 6);

	}

}
