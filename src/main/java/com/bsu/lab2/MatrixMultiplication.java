package main.java.com.bsu.lab2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		double[][] dataMultiplied = null;
		double[][] dataMultipying = null;
		FileReader fl = null;
		try {
			fl = new FileReader("TestMulty.txt");
			Scanner sc = new Scanner(fl);
			int n = sc.nextInt();
			dataMultiplied = new double[n][n];
			MatrixFromFile(dataMultiplied, sc);
			dataMultipying = new double[n][n];
			MatrixFromFile(dataMultipying, sc);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Matrix multiplied: ");
		MatrixOut(dataMultiplied);
		System.out.println("\nMatrix multipying: ");
		MatrixOut(dataMultipying);
		
		double[] maxElem = MatrixMaxElem(dataMultipying);
		System.out.println("\nMax elements: ");
		for(int i = 0; i < maxElem.length; i++)
			System.out.print(formattedNumericValue(maxElem[i])  + " ");
		MatrixMultiply(dataMultiplied, maxElem);
		
		System.out.println("\n\nMatrix multiplied result: ");
		MatrixOut(dataMultiplied);
	}

	public static double[] MatrixMaxElem(double[][] data) {
		double[] returnValue = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			double max = Double.MIN_VALUE;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > max)
					max = data[i][j];
			}
			returnValue[i] = max;
		}
		return returnValue;
	}
	
	public static void MatrixFromFile(double[][] data, Scanner sc) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j< data[i].length; j++) {
				data[j][i] = sc.nextDouble();
			}
		}
	}
	
	public static void MatrixMultiply(double[][] matrix, double[] data) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] *= data[i];
			}
		}
	}
	
	public static void MatrixOut(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(formattedNumericValue(data[i][j])  + " ");
			}
			System.out.println("");
		}
	}
	
	public static String formattedNumericValue(double value) {
	    return String.format("%.1f", value);
	}
	
}
