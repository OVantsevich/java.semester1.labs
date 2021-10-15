  package main.java.com.bsu.lab2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixSumAbs {

	public static void main(String[] args) {
		FileReader fl = null;
		int[][] data = null;
		try {
			fl = new FileReader("TestAbsSum.txt");
			Scanner sc = new Scanner(fl);
			int n = sc.nextInt();
			//int m = sc.nextInt();
			//data = new int[n][m]
			data = new int[n][n];
			MatrixFromFile(data, sc);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Matrix: ");
		MatrixOut(data);
		
		boolean[] odd = IfOdd(data);
		System.out.println("\nOdd strings: ");
		for(int i = 0; i < odd.length; i++)
			System.out.print(odd[i] + " ");
		
		int[] absSum = SumAbs(data, odd);
		System.out.println("\nSum of odd strings: ");
		for(int i = 0; i < odd.length; i++)
			System.out.print(absSum[i]  + " ");
		
		int max= Integer.MIN_VALUE;
		int index = 0;
		for(int i = 0; i < odd.length; i++) {
			if(max < absSum[i]) {
				max = absSum[i];
				index = i;
			}
		}
				
		System.out.println("\n\nString number: " + index);
	}
	
	public static void MatrixFromFile(int[][] data, Scanner sc) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j< data[i].length; j++) {
				data[i][j] = sc.nextInt();
			}
		}
	}
	
	public static boolean[] IfOdd(int[][] matrix) {
		boolean[] data = new boolean[matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			data[i] = true;
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] % 2 == 0)
					data[i] = false;
			}
		}
		return data;
	}
	
	public static int[] SumAbs(int[][] matrix, boolean[] data) {
		int[] returnResult = new int[matrix.length];
			for(int i = 0; i < matrix.length; i++) {
				if(data[i]) {
				for(int j = 0; j < matrix[i].length; j++) {
						returnResult[i] += Math.abs(matrix[i][j]);
					} 
				}
			}
		return returnResult;
	}
	
	public static void MatrixOut(int[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]  + " ");
			}
			System.out.println("");
		}
	}


}
