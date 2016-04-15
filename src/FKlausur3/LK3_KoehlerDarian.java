package FKlausur3;

import java.util.Scanner;

public class LK3_KoehlerDarian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wie viele unterschiedliche Produkte haben sie?");
		int length = sc.nextInt();
		double[] x = new double[length];
		double[] y = new double[length];

		System.out.print("Erfassen die die Preise aller Produkte:\n");
		for (int i = 0;i < x.length;i++) {
			System.out.print("Preis des Produkts " +(i+1) +": ");
			x[i] = sc.nextDouble();
		}

		System.out.print("Erfassen die die Verkaufsmengen aller Produkte:\n");
		for (int i = 0;i < x.length;i++) {
			System.out.print("Verkaufszahlen des Produkts " +(i+1) +": ");
			y[i] = sc.nextDouble();
		}

		System.out.println(
				"Der mittlere Preis ist: " +berechneMittelwert(x)
				+"\nDie mittlere Verkaufsmenge ist: " +berechneMittelwert(y)
				+"\nDie Preisvarianz ist: " +berechneVarianz(x)
				+"\nDie Kovarianz ist: " +berechneKovarianz(x, y)
				+"\nDer Regressionskoeffizient A ist: " +berechneRegB(x, y)
				+"\nDer Regressionskoeffizient B ist: " +berechneRegA(x, y));

	}

	private static double berechneMittelwert(double[] x) {
		double mit = 0;
		for (int i = 0;i < x.length;i++) {
			mit += x[i];

		}

		mit /= x.length;
		return mit;

	}

	private static double berechneVarianz(double[] x) {
		double var = 0, mit = berechneMittelwert(x);
		for (int i = 0;i < x.length;i++) {
			var += Math.pow((x[i] - mit), 2);
		}

		return var / x.length;

	}

	private static double berechneKovarianz(double[] x, double[] y) {
		double kovar = 0, mit1 = berechneMittelwert(x), mit2 = berechneMittelwert(y);
		for (int i = 0;i < x.length;i++) {
			kovar += (x[i] - mit1) * (y[i] - mit2);
		}

		return kovar / x.length;

	}

	private static double berechneRegB(double[] x, double[] y) {
		double regB = 0, kovar = berechneKovarianz(x, y), var = berechneVarianz(x);
		regB = kovar/var;
		
		return regB;

	}

	private static double berechneRegA(double[] x, double[] y) {		
		double regA = 0;
		double regB = berechneRegB(x, y);
		double mitX = berechneMittelwert(x);
		double mitY = berechneMittelwert(y);
		
		regA = mitY - regB * mitX;
		return regA;

	}

}
