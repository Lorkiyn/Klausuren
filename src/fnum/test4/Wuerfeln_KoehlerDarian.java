/* Darian K�hler */
package fnum.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wuerfeln_KoehlerDarian {

	public static void main(String[] args) throws IOException {
		System.out.print("Wie viele Experimente sollen durchgef�hrt werden: ");
		int amountAll = readInt();

		System.out.print("Wie viele W�rfel pro Experiment: ");
		int amount = readInt();

		int[][] w�rfel = new int[amountAll][amount];
		double[] mid = null;
		double[] defVar = null;

		System.out.println("");
		for (int i = 0; i < w�rfel.length; i++) {
			System.out.println("W�rfel " +(i+1) +": ");
			for (int j = 0; j < w�rfel[i].length; j++) {
				System.out.print("Wurf " +(j+1) +": ");
				w�rfel[i][j] = readInt();

			}

			System.out.println("");

		}

		System.out.println("\nW�rfelexperimente:");
		for (int i = 0; i < w�rfel.length; i++) {

			System.out.print((i+1) +". ");

			for (int j = 0; j < w�rfel[i].length; j++) {
				System.out.print(w�rfel[i][j] +"  ");

			}

			System.out.println("");

		}

		System.out.println("\nGesammt Summe: " +getSum(w�rfel));
		System.out.println("H�chste Augenzahl: " +getMax(w�rfel));
		System.out.println("Niedrigste Augenzahl: " +getMin(w�rfel));
		System.out.println("Mittelwert:");
		mid = getMid(w�rfel);
		defVar = getDefVar(w�rfel);
		for (int i = 0; i < w�rfel.length; i++) {
			System.out.println((i+1) +". " +mid[i]);

		}

		System.out.println("\nStandart Abweichung:");
		for (int i = 0; i < w�rfel.length; i++) {
			System.out.println((i+1) +". " +defVar[i]);

		}


	}

	private static int getSum(int[][] w�rfel) {
		int sum = 0;
		
		for (int i = 0; i < w�rfel.length; i++) {
			for (int j = 0; j < w�rfel[i].length; j++) {
				sum += w�rfel[i][j];
				
			}

		}

		return sum;
	}

	private static int getMin(int[][] w�rfel) {
		int min = w�rfel[0][0];

		for (int i = 0; i < w�rfel.length; i++) {
			for (int j = 0; j < w�rfel[i].length; j++) {
				if (w�rfel[i][j] < min) {
					min = w�rfel[i][j];
				}

			}

		}

		return min;

	}

	private static int getMax(int[][] w�rfel) {
		int max = 0;

		for (int i = 0; i < w�rfel.length; i++) {
			for (int j = 0; j < w�rfel[i].length; j++) {
				if (w�rfel[i][j] > max) {
					max = w�rfel[i][j];
				}

			}

		}

		return max;

	}

	private static double[] getMid(int[][] w�rfel) {
		double[] mid = new double[w�rfel.length];
		for (int i = 0; i < w�rfel.length; i++) {

			double middle = 0;

			for (int j = 0; j < w�rfel[i].length; j++) {
				middle += w�rfel[i][j];
			}

			mid[i] = middle/w�rfel[i].length;

		}

		return mid;

	}

	private static double[] getVar(int[][] w�rfel) {
		double[] var = new double[w�rfel.length];
		double[] mid = getMid(w�rfel);
		for (int i = 0; i < w�rfel.length; i++) {

			for (int j = 0; j < w�rfel[i].length; j++) {
				var[i] += Math.pow(w�rfel[i][j] - mid[i], 2);

			}

			var[i] /= w�rfel[i].length; 

		}

		return var;
	}

	private static double[] getDefVar(int[][] w�rfel) {
		double[] defVar = new double[w�rfel.length];
		double[] var = getVar(w�rfel);
		for (int i = 0; i < w�rfel.length; i++) {

			for (int j = 0; j < w�rfel[i].length; j++) {
				defVar[i] = Math.sqrt(var[i]);

			}

		}

		return defVar;
		
	}

	private static int readInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				String i = br.readLine();
				return Integer.parseInt(i.trim());

			} catch (NumberFormatException e) {
				System.out.print("Keine Ganzzahl! Bitte erneut versuchen: ");
			}

		}

	}

}
