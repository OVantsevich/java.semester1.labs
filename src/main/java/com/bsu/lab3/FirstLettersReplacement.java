package main.java.com.bsu.lab3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FirstLettersReplacement {

	public static void main(String[] args) {
		StringBuffer data = GetText("TestFirstLetter.txt");
		String delimiter = GetDelimiter();
		Replacement(data, delimiter);
		System.out.println(data);
	}
	
	public static StringBuffer GetText(String fileName) {
		StringBuffer data = new StringBuffer("");
		try { 
			File myObj = new File(fileName);
			Scanner myScanner = new Scanner(myObj);
			while(myScanner.hasNextLine())
			{
				data.append("\n" + myScanner.nextLine());	
			}
			myScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}
	
	public static String GetDelimiter() {
		String data = null;
		Scanner myScanner = new Scanner(System.in);
		data = myScanner.nextLine();	
		myScanner.close();
		return data;
	}

	public static void Replacement(StringBuffer data, String delimiter) {
		StringTokenizer strTok = new StringTokenizer(data.toString(), delimiter);
		int index = 0;
		//if(IsUppercase(data.charAt(index))) {
		//	data.setCharAt(index, (char)(data.charAt(index) + 32));
		//	strTok.nextToken();
		//	index++;
		//}
		while(strTok.hasMoreTokens()) {
			String token = strTok.nextToken();
			index = data.indexOf(token, index);
			if(!(IsUppercase(data.charAt(index)))) {
				data.setCharAt(index, (char)((int)data.charAt(index) + 'A' - 'a'));
			} 
			index++;
		}
	}
	
	public static boolean IsUppercase(char a){
		if(a > 64 && a < 91)
			return true;
		return false;
	}
	
}