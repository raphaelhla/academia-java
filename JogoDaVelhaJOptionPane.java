package sef.module4.activity;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class JogoDaVelhaJOptionPane {

	private static char[][] tabuleiro = {
		{' ', ' ', ' '},
		{' ', ' ', ' '},
		{' ', ' ', ' '}
	};
	
	private static int jogador = 1;
	private static int jogadas = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean partidaEmAndamento = true;
		do {
			imprimirTabuleiro();
			jogar(sc);
			
			if (verificaSeHouveVencedor()) {
				imprimirTabuleiro();
				System.out.println("\n\tParabéns Jogador " + jogador + ". Você ganhou!\n");
				partidaEmAndamento = false;
			} else if (jogadas == 9) {
				imprimirTabuleiro();
				System.out.println("\n\t DEU VEA!\n");
				partidaEmAndamento = false;
			}
			
			jogador = (jogador == 1) ? 2 : 1;

		} while (partidaEmAndamento );
		
		sc.close();
	}

	public static boolean verificaSeHouveVencedor() {
		// Verificar linhas
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[i][0] != ' ' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
				return true;
			}
		}

		// Verificar colunas
		for (int i = 0; i < 3; i++) {
			if (tabuleiro[0][i] != ' ' && tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
				return true;
			}
		}

		// Verificar diagonais
		if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
			return true;
		}
		if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
			return true;
		}

		return false;
	}

	public static void jogar(Scanner sc) {
		int linha, coluna;
		boolean posicaoValida = false;
		
		do {
			String entradaLinha = JOptionPane.showInputDialog("Jogador " + jogador + " digite a linha da posicao desejada (0, 1, ou 2): ");
			String entradaColuna = JOptionPane.showInputDialog("Jogador " + jogador + " digite a coluna da posicao desejada (0, 1, ou 2): ");
			
			linha = Integer.parseInt(entradaLinha);
			coluna = Integer.parseInt(entradaColuna);
			
			posicaoValida = verificarValidadeDaPosicao(linha, coluna);
			
			if (!posicaoValida) { 	
				JOptionPane.showMessageDialog(null, "Posicao inválida. Tente novamente.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} while (!posicaoValida);
		
		tabuleiro[linha][coluna] = (jogador == 1) ? 'O' : 'X';
		jogadas++;
	}
	
	public static boolean verificarValidadeDaPosicao(int linha, int coluna) {
		boolean linhaValida = linha >= 0 && linha <= 2;
		boolean colunaValida = coluna >= 0 && coluna <= 2;
		boolean posicaoValida = linhaValida && colunaValida && tabuleiro[linha][coluna] == ' ';
		
		return (linhaValida && colunaValida) && posicaoValida;
	}
	
	public static void imprimirTabuleiro() {
		System.out.print("\n\n 0   1    2\n\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				System.out.print(" " + tabuleiro[posicao1][posicao2]);
				if (posicao2 < 2) {
					System.out.print(" |");
				}
				if (posicao2 == 2) {
					System.out.print("  " + posicao1);
				}
			}
			if (posicao1 < 2) {
				System.out.print("\n------------");
			}
			System.out.println("\n");
		}
	}
}
