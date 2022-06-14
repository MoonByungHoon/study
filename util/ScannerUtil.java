package util;

import java.util.Scanner;

public class ScannerUtil {

	public static int nextInt(Scanner sc2, String message) { // 버퍼가 비워진 nextLine
		Scanner sc = new Scanner(System.in);
		System.out.print(">");

		sc.nextLine();
		
		int result = sc.nextInt();
		
		return result;
	}
}
