package main.java.com.bsu.lab2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixSorting {
	public static void main(String[] agrs) {
		FileReader fl = null;
		double[][] data = null;
		try {
			fl = new FileReader("TestSort.txt");
			Scanner sc = new Scanner(fl);
			int n = sc.nextInt();
			data = new double[n][n];
			MatrixFromFile(data, sc);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Matrix: ");
		MatrixOut(data);
		
		double[] minElem = MatrixMinElem(data);
		System.out.println("\nMin elements: ");
		for(int i = 0; i < minElem.length; i++)
			System.out.print(formattedNumericValue(minElem[i])  + " ");
		
		QuickSort(minElem, data, 0, minElem.length - 1);
		
		System.out.println("\n\nNew matrix: ");
		MatrixOut(data);
	}
	
	public static void MatrixFromFile(double[][] data, Scanner sc) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j< data[i].length; j++) {
				data[j][i] = sc.nextDouble();
			}
		}
	}
	
	public static double[] MatrixMinElem(double[][] data) {
		double[] returnValue = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			double min = Double.MAX_VALUE;
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] < min)
					min = data[i][j];
			}
			returnValue[i] = min;
		}
		return returnValue;
	}
	
	public static void RandomFilling(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				data[i][j] = Math.random() * 9 + Math.random();
			}
		}
	}
	
	public static void MatrixOut(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(formattedNumericValue(data[j][i])  + " ");
			}
			System.out.println("");
		}
	}
	
	public static String formattedNumericValue(double value) {
	    return String.format("%.1f", value);
	}
	
	 public static void QuickSort(double[] keysArray, double[][] sortingMatrix, int low, int high) {
         if (keysArray.length == 0)
             return;

         if (low >= high)
             return;

         int middle = low + (high - low) / 2;
         double opora = keysArray[middle];

         int i = low, j = high;
         while (i <= j) {
             while (keysArray[i] < opora) {
                 i++;
             }

             while (keysArray[j] > opora) {
                 j--;
             }

             if (i <= j) {
            	 double tempD = keysArray[i];
            	 keysArray[i] = keysArray[j];
            	 keysArray[j] = tempD;
                 double[] temp = sortingMatrix[i];
                 sortingMatrix[i] = sortingMatrix[j];
                 sortingMatrix[j] = temp;
                 i++;
                 j--;
             }
         }
         if (low < j)
        	 QuickSort(keysArray, sortingMatrix, low, j);

         if (high > i)
        	 QuickSort(keysArray, sortingMatrix, i, high);
	 }
}
