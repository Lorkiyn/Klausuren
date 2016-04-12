//Aufgabe 1 Darian
package FKlausur1;

import java.util.Scanner;

public class Aufgabe1Darian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bitte die Rente eingeben: ");
		double r = sc.nextDouble();
		System.out.print("Bitte die Laufzeit eigeben: ");
		double n = sc.nextDouble();
		System.out.print("Bitte den Zinssatz eigeben: ");
		double p = sc.nextDouble();
		
		double q = 1+p;
		double rn = r * Math.pow(q, n)-1 / q-1;
		
		System.out.println("Ergebniss: " +rn);}

}
