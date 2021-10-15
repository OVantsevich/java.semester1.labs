package main.java.com.bsu.lab9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		String[] data;
		data = InputData("inputLab9.txt");
		String[] newData = new String[3];
		newData[0] = RemovingParentheses(data[0]);
		newData[1] = RemovingNumbers(data[1]);
		newData[2] = RemovingZero(data[2]);
		System.out.println("Input data1: " + data[0]);
		System.out.println("Ouput data1: " + newData[0] + "\n");
		System.out.println("Input data2: " + data[1]);
		System.out.println("Ouput data2: " + newData[1] + "\n");
		System.out.println("Input data3: " + data[2]);
		System.out.println("Ouput data3: " + newData[2]);
		OutputData(newData, "outputLab9.txt");
	}
	
	public static String RemovingParentheses(String data) {
		String stringPattern = "[(]{1}[^()]*[)]{1}";
		Pattern pattern = Pattern.compile(stringPattern);
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()) {
			String[] array = pattern.split(data); 
			data = "";
	        for(String i : array)
	        	data += i;
	        matcher = pattern.matcher(data);
		}
		
		return data;
	}
	
	public static String RemovingNumbers(String data) {
		String stringPattern = "[0-9]{2,}";
		StringBuffer newData = new StringBuffer("");
		Pattern pattern = Pattern.compile(stringPattern);
		Matcher matcher = pattern.matcher(data);
		while(matcher.find()) 
			matcher.appendReplacement(newData, data.substring(matcher.start(), matcher.start() + 2));
		return newData.toString();
	}
	
	public static interface Operationable{
	    int calculate(String str, int i);
	}
	
	public static String RemovingZero(String data) {
		String stringPattern = "[0-9]{2,}";
		StringBuffer newData = new StringBuffer("");
		Pattern pattern = Pattern.compile(stringPattern);
		Matcher matcher = pattern.matcher(data);
		
		Operationable operation;
		operation = (str, i) -> {
			while(str.charAt(i) == '0') ++i;
			return i;
		};
		
		while(matcher.find()) 
			matcher.appendReplacement(newData, data.substring(operation.calculate(data, matcher.start()), matcher.end()));
		
		return newData.toString();
	}
	
	public static String[] InputData(String fileName) {
		String[] data = new String[3];
		try {
			FileReader fl = new FileReader(fileName);
			Scanner sc = new Scanner(fl);
			
			int i = 0;
			while(sc.hasNextLine())
				data[i++] = sc.nextLine();
			
			sc.close();
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void OutputData(String[] data, String fileName) {
		 try {
			  FileWriter fl = new FileWriter(fileName);
			  
			  for(int i = 0; i < data.length; i++) {
				  fl.write(data[i] + "\n");
			  }
		      
		      fl.close();
		 } catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
	}

}
