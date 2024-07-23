package atividades;

import java.util.Scanner;

public class Atividade01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o número de ingressos vendidos na categoria: Classe A");
		int ingressosClasseA = sc.nextInt();
		
		System.out.println("Digite o número de ingressos vendidos na categoria: Classe B");
		int ingressosClasseB = sc.nextInt();
		
		System.out.println("Digite o número de ingressos vendidos na categoria: Classe C");
		int ingressosClasseC = sc.nextInt();
		
		int rendaTotal = ingressosClasseA * 50 + ingressosClasseB * 30 + ingressosClasseC * 20;
		
		System.out.printf("A renda total gerada pela venda de ingressos foi de: R$ %d", rendaTotal);
	}
}
