//Aufgabe 2 Darian
package fnum.test1;

import java.util.Scanner;

public class Aufgabe2Darian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Netto Auftragswert: ");
		double netto = sc.nextDouble();

		if (netto <= 100) {
			netto = netto + 8.50;
			double tax = (netto/100) * 19;
			netto = netto + tax;
			System.out.println("Mehrwertssteuer: " +tax);
			System.out.println("Rechnungsbetrag: " +netto);
		} else if (netto >= 100 && netto <=200) {
			netto = netto + 5;
			double tax = (netto/100) * 19;
			netto = netto + tax;
			System.out.println("Mehrwertssteuer: " +tax);
			System.out.println("Rechnungsbetrag: " +netto);
		} else if (netto > 200) {
			double tax = (netto/100) * 19;
			netto = netto + tax;
			System.out.println("Mehrwertssteuer: " +tax);
			System.out.println("Rechnungsbetrag: " +netto);
		}
		
		sc.close();
	}

}
