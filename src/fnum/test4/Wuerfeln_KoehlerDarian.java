/* Darian Köhler */
package fnum.test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wuerfeln_KoehlerDarian {

	public static void main(String[] args) throws IOException {
		System.out.print("Wie viele Experimente sollen durchgeführt werden: ");
		int amountAll = readInt();

		System.out.print("Wie viele Würfel pro Experiment: ");
		int amount = readInt();

		int[][] würfel = new int[amountAll][amount];
		double[] mid = null;
		double[] defVar = null;

		System.out.println("");
		for (int i = 0; i < würfel.length; i++) {
			System.out.println("Würfel " +(i+1) +": ");
			for (int j = 0; j < würfel[i].length; j++) {
				System.out.print("Wurf " +(j+1) +": ");
				würfel[i][j] = readInt();

			}

			System.out.println("");

		}

		System.out.println("\nWürfelexperimente:");
		for (int i = 0; i < würfel.length; i++) {

			System.out.print((i+1) +". ");

			for (int j = 0; j < würfel[i].length; j++) {
				System.out.print(würfel[i][j] +"  ");

			}

			System.out.println("");

		}

		System.out.println("\nGesammt Summe: " +getSum(würfel));
		System.out.println("Höchste Augenzahl: " +getMax(würfel));
		System.out.println("Niedrigste Augenzahl: " +getMin(würfel));
		System.out.println("Mittelwert:");
		mid = getMid(würfel);
		defVar = getDefVar(würfel);
		for (int i = 0; i < würfel.length; i++) {
			System.out.println((i+1) +". " +mid[i]);

		}

		System.out.println("\nStandart Abweichung:");
		for (int i = 0; i < würfel.length; i++) {
			System.out.println((i+1) +". " +defVar[i]);

		}


	}

	private static int getSum(int[][] würfel) {
		int sum = 0;
		
		for (int i = 0; i < würfel.length; i++) {
			for (int j = 0; j < würfel[i].length; j++) {
				sum += würfel[i][j];
				
			}

		}

		return sum;
	}

	private static int getMin(int[][] würfel) {
		int min = würfel[0][0];

		for (int i = 0; i < würfel.length; i++) {
			for (int j = 0; j < würfel[i].length; j++) {
				if (würfel[i][j] < min) {
					min = würfel[i][j];
				}

			}

		}

		return min;

	}

	private static int getMax(int[][] würfel) {
		int max = 0;

		for (int i = 0; i < würfel.length; i++) {
			for (int j = 0; j < würfel[i].length; j++) {
				if (würfel[i][j] > max) {
					max = würfel[i][j];
				}

			}

		}

		return max;

	}

	private static double[] getMid(int[][] würfel) {
		double[] mid = new double[würfel.length];
		for (int i = 0; i < würfel.length; i++) {

			double middle = 0;

			for (int j = 0; j < würfel[i].length; j++) {
				middle += würfel[i][j];
			}

			mid[i] = middle/würfel[i].length;

		}

		return mid;

	}

	private static double[] getVar(int[][] würfel) {
		double[] var = new double[würfel.length];
		double[] mid = getMid(würfel);
		for (int i = 0; i < würfel.length; i++) {

			for (int j = 0; j < würfel[i].length; j++) {
				var[i] += Math.pow(würfel[i][j] - mid[i], 2);

			}

			var[i] /= würfel[i].length; 

		}

		return var;
	}

	private static double[] getDefVar(int[][] würfel) {
		double[] defVar = new double[würfel.length];
		double[] var = getVar(würfel);
		for (int i = 0; i < würfel.length; i++) {

			for (int j = 0; j < würfel[i].length; j++) {
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
