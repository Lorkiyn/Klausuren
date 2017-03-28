package fnum.lk.test1;

import java.util.Scanner;

public class LK1_M_DarianKöhler {

	private static int fValue;
	private static final double TOLERANZ = 0.000001;

	public static void main(String[] args) {
		//fValue = Integer.parseInt(args[0]);
		//args geht nicht :(
		fValue = 3;
		menu();
	}

	@SuppressWarnings("resource")
	private static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-------------------------------");
		System.out.println("[I] Intervallhalbierung");
		System.out.println("[S] Sekantenverfahren");
		System.out.println("[N] Newtonverfahren");
		System.out.println("[X] Beenden\n");

		System.out.print("Auswahl: ");
		String i = sc.nextLine();

		System.out.println("-------------------------------\n");
	
		if(fValue == 1) {
			calcNewton(3);
			System.out.println("-------------------------------\n");
			return;
		}
		
		if (i.equalsIgnoreCase("i")) {
			initIntervall();
		} else if (i.equalsIgnoreCase("s")) {
			initSekante();
		} else if (i.equalsIgnoreCase("n")) {
			initNewton();
		} else if (i.equalsIgnoreCase("x")) {
			System.exit(0);
		} else {
			menu();
		}
		sc.close();
	}

	private static void initIntervall() {
		Scanner sc = new Scanner(System.in);
		double lowerX = 0;
		double upperX = 0;
		System.out.println("Intervallhalbierungsverfahren:\n");
		System.out.print("Bitte geben Sie die Untergrenze ein: ");
		lowerX = sc.nextDouble();
		System.out.print("Bitte geben Sie nun die Obergrenze ein: ");
		upperX = sc.nextDouble();
		calcIntervall(lowerX, upperX);
		sc.close();
	}
	
	private static void calcIntervall(double lowerX, double upperX) {
		double xStar = 0;
		int count = 0;

		do {
			xStar = (upperX + lowerX) / 2;

			if(f(xStar) * f(upperX) < 0) {
				lowerX = xStar;
			} else {
				upperX = xStar;
			}
			count++;

		} while(Math.abs(f(xStar)) > TOLERANZ);

		System.out.println("Ergebnis Intervall x = " + r(xStar));
		System.out.println("Nach: " + count + " durchläufen, auf " + TOLERANZ + " genau.");
		menu();
	}
	
	private static void initSekante() {
		Scanner sc = new Scanner(System.in);
		double x0 = 0;
		double x1 = 0;
		System.out.println("Sekantenverfahren:\n");
		System.out.print("Bitte geben Sie x1 ein: ");
		x0 = sc.nextDouble();
		System.out.print("Bitte geben Sie x2 ein: ");
		x1 = sc.nextDouble();
		calcSekante(x0, x1);
		sc.close();
	}

	private static void calcSekante(double x0, double x1) {
		double count = 0;
		double xStar = 0;
		do {
			xStar = x0 - f(x0) * ( (x0 - x1) / (f(x0) - f(x1) ));

			x1 = xStar;
			count++;

		} while(Math.abs(f(xStar)) > TOLERANZ);

		System.out.println("Ergebnis Sekante x = " + r(xStar));
		System.out.println("Nach: " + count + " durchläufen, auf " + TOLERANZ + " genau.");
		menu();
		}

	private static void initNewton() {
		Scanner sc = new Scanner(System.in);
		double x0 = 0;
		System.out.println("Newton Verfahren:\n");
		System.out.print("Bitte geben Sie x0 ein: ");
		x0 = sc.nextDouble();
		calcNewton(x0);
		sc.close();
		menu();
	}
	
	private static double calcNewton(double x0) {
		int count = 0;
		double xStar = 0;
		do {
			xStar = x0 - f(x0) / fAbl(x0);

			x0 = xStar;
			count++;

		} while(Math.abs(f(xStar)) > TOLERANZ);

		System.out.println("Ergebnis Newton x = " + r(xStar));
		System.out.println("Nach: " + count + " durchläufen, auf " + TOLERANZ + " genau.");
		return xStar;
	}

	private static double r(double x) {
		return Math.round(x * 100000.0) / 100000.0;
	}

	private static double fAbl(double x) {
		if (fValue == 2) {
			return Math.pow(3 * x, 2) - (2 * x) - 1;
		} else if (fValue == 3) {
			return Math.pow(3 * x, 2) + 4 * x;
		} else {
			return calcNewton(3);
		}
	}

	private static double f(double x) {
		if (fValue == 2) {
			return Math.pow(x, 3) - Math.pow(x, 2) - x - 5;
		} else if (fValue == 3) {
			return Math.pow(x, 3) + (Math.pow(x, 2) * 2) + 7;
		} else {
			return calcNewton(3);
		}
	}
}
