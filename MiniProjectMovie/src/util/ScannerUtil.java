package util;

import java.util.Scanner;

public class ScannerUtil {
	ScannerUtil sc = new ScannerUtil();

	public static void message(String message) {
		System.out.println("----------------------------------------");
		System.out.println(message);
		System.out.println("----------------------------------------");
	}

	public static int nextInt(Scanner sc, String message) {
		message(message);
		System.out.printf("> ");

		return sc.nextInt();
	}

	public static String nextLine(Scanner sc, String message) {
		message(message);
		System.out.printf("> ");

		return sc.nextLine();
	}
}
