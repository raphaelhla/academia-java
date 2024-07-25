package sef.module4.activity;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChessBoardJOptionPane {

	private static String[][] board = { 
			{ "R", "N", "B", "Q", "K", "B", "N", "R" },
			{ "P", "P", "P", "P", "P", "P", "P", "P" },
			{ " ", " ", " ", " ", " ", " ", " ", " " }, 
			{ " ", " ", " ", " ", " ", " ", " ", " " },
			{ " ", " ", " ", " ", " ", " ", " ", " " }, 
			{ " ", " ", " ", " ", " ", " ", " ", " " },
			{ "p", "p", "p", "p", "p", "p", "p", "p" }, 
			{ "r", "n", "b", "q", "k", "b", "n", "r" } };
	
	private static int jogador = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean partidaEmAndamento = true;
		do {
			imprimirBoard(board);
			jogar(sc);
			jogador = (jogador == 1) ? 2 : 1;

		} while (partidaEmAndamento );
		
		sc.close();
	}

	public static void jogar(Scanner sc) {
		int linhaOrigem, colunaOrigem, linhaDestino, colunaDestino;
		boolean movimentoValido = false;

		do {
			String entradaLinhaOrigem = JOptionPane.showInputDialog("Jogador " + jogador + ", digite a linha da posição do peão que deseja mover (0-7): ");
			String entradaColunaOrigem = JOptionPane.showInputDialog("Jogador " + jogador + ", digite a coluna da posição do peão que deseja mover (0-7): ");
			String entradaLinhaDestino = JOptionPane.showInputDialog("Jogador " + jogador + ", digite a linha de destino (0-7): ");
			String entradaColunaDestino = JOptionPane.showInputDialog("Jogador " + jogador + ", digite a coluna de destino (0-7): ");
					
			linhaOrigem = Integer.parseInt(entradaLinhaOrigem);
			colunaOrigem = Integer.parseInt(entradaColunaOrigem);
			linhaDestino = Integer.parseInt(entradaLinhaDestino);
			colunaDestino = Integer.parseInt(entradaColunaDestino);

			if (verificarMovimentoPeao(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
				board[linhaDestino][colunaDestino] = board[linhaOrigem][colunaOrigem];
				board[linhaOrigem][colunaOrigem] = " ";
				movimentoValido = true;
			} else {
				JOptionPane.showMessageDialog(null, "Movimento inválido. Tente novamente.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} while (!movimentoValido);
		
	}
	
	public static boolean verificarMovimentoPeao(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		String peca = board[linhaOrigem][colunaOrigem];
		String destino = board[linhaDestino][colunaDestino];

		if (peca.equals("P") && jogador == 1) { 
			if (linhaOrigem == 1 && linhaDestino == 3 && colunaOrigem == colunaDestino && destino.equals(" ")) {
				return true; // Movimento inicial de duas casas
			} else if (linhaDestino == linhaOrigem + 1 && colunaOrigem == colunaDestino && destino.equals(" ")) {
				return true; // Movimento de uma casa para frente
			} else if (linhaDestino == linhaOrigem + 1 && Math.abs(colunaDestino - colunaOrigem) == 1 && !destino.equals(" ")) {
				return true; // Captura
			}
		} else if (peca.equals("p") && jogador == 2) { 
			if (linhaOrigem == 6 && linhaDestino == 4 && colunaOrigem == colunaDestino && destino.equals(" ")) {
				return true; // Movimento inicial de duas casas
			} else if (linhaDestino == linhaOrigem - 1 && colunaOrigem == colunaDestino && destino.equals(" ")) {
				return true; // Movimento de uma casa para frente
			} else if (linhaDestino == linhaOrigem - 1 && Math.abs(colunaDestino - colunaOrigem) == 1 && !destino.equals(" ")) {
				return true; // Captura
			}
		}

		return false;
	}

	public static void imprimirBoard(String[][] board) {
		System.out.println("\n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("\n--------------------------");
	}
}
