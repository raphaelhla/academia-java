package sef.module4.activity;

import javax.swing.JOptionPane;

public class Retangulo {

	public static void main(String[] args) {
		Retangulo novoRetangulo = new Retangulo();
		
		for (int i = 0; i < 5; i++) {
			String entradaLado1 = JOptionPane.showInputDialog("Digite o lado1 do retangulo: ");
			String entradaLado2 = JOptionPane.showInputDialog("Digite o lado2 do retangulo: ");
			
			double lado1 = Double.parseDouble(entradaLado1);
			double lado2 = Double.parseDouble(entradaLado2);
			
			novoRetangulo.setLado1(lado1);
			novoRetangulo.setLado2(lado2);
			
			novoRetangulo.calcularArea();
			novoRetangulo.calcularPerimetro();
		}
	}
	
	private double lado1;
	private double lado2;
	private double area;
	private double perimetro;
	
	public Retangulo() {
		this.lado1 = 0;
        this.lado2 = 0;
        this.area = 0;
        this.perimetro = 0;
	}
	
	public Retangulo(double lado1, double lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public void calcularArea() {
		this.area = lado1 * lado2;
		
		String mensagem = String.format("Lado1: %.2f\nLado2: %.2f\n\nArea = %.2f", lado1, lado2, area);
		JOptionPane.showMessageDialog(null, mensagem, "Area do retangulo", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void calcularPerimetro() { 
		this.perimetro = 2 * (lado1 + lado2);
		
		String mensagem = String.format("Lado1: %.2f\nLado2: %.2f\n\nPerimetro = %.2f", lado1, lado2, perimetro);
		JOptionPane.showMessageDialog(null, mensagem, "Perimetro do retangulo", JOptionPane.PLAIN_MESSAGE);
	}

	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}
}
