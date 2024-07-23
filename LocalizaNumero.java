package sef.module3.sample;

import java.util.Scanner;

//Faça um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
public class LocalizaNumero {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		

		int vetor[] = {1, 3, 5, 8, 9, 10};
		
		System.out.println("Digite o número que voê deseja buscar no vetor: ");
		int numero = sc.nextInt();
    
		boolean achou = false;
		int posicao = -1;
		
		for (int i=0; i<vetor.length; i++) {
			if (vetor[i] == numero){
				achou = true;
				posicao = i;
				break;
		  }
		}
		
		if (achou) {
	    System.out.println("Achei");
	    System.out.printf("Na Posição %d está localizado do numero %d.", posicao, vetor[posicao]);			
		} else {
			System.out.println("Não achei :(");
			System.out.printf("O numero %d não faz parte do array.", numero);	
		}
	}
}
