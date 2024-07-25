package sef.module4.activity;

import javax.swing.JOptionPane;

public class Circulo {
	
	public static void main(String[] args) {
		Circulo novoCirculo = new Circulo();
		
		for (int i = 0; i < 5; i++) {
			String entradaRaio = JOptionPane.showInputDialog("Digite o raio do  circulo: ");
			
			double raio = Double.parseDouble(entradaRaio);
			novoCirculo.setRaio(raio);
			
			novoCirculo.calcularArea();
			novoCirculo.calcularPerimetro();
		}
	}
	
    private double raio;
    private double area;
    private double perimetro;

    public Circulo() {
        this.raio = 0;
        this.area = 0;
        this.perimetro = 0;
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    public void calcularArea() {
        this.area = raio * raio * 3.14;
        
        String mensagem = String.format("Raio: %.2f\n\nArea = %.2f", raio, area);
		JOptionPane.showMessageDialog(null, mensagem, "Area do circulo", JOptionPane.PLAIN_MESSAGE);
    }

    public void calcularPerimetro() {
        this.perimetro = 2 * 3.14 * raio;
        
        String mensagem = String.format("Raio: %.2f\n\nPerimetro = %.2f", raio, perimetro);
		JOptionPane.showMessageDialog(null, mensagem, "Perimetro do circulo", JOptionPane.PLAIN_MESSAGE);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
