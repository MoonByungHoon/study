package util;

import java.util.Scanner;

public class ScannerUtil {
	public static int nextInt(Scanner sc, String message) {
		print(message);
		
		return sc.nextInt();
	}
	
	public static String nextLine(Scanner sc, String message) {
		print(message);
		
		String temp = sc.nextLine();
		
		if(temp.isEmpty()) {
			temp = sc.nextLine();
		}
		
		return temp;
	}
	
	public static void print(String message) {
		System.out.println("----------------------------------------");
		System.out.println(message);
		System.out.println("----------------------------------------");
		System.out.print("> ");
	}
}