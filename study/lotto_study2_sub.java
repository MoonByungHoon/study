package study;

import java.util.Random;

import util.ArrayUtil;
import util.ScannerUtil;

public class lotto_study2_sub {
	public static int[] setAutoNum() {

		int[] temp = new int[0];

		Random ran = new Random();

		while (ArrayUtil.size(temp) < lotto_study2.SIZE_MAX) {
			int randomNumber = ran.nextInt(lotto_study2.NUMBER_MAX) + lotto_study2.NUMBER_MIN;

			if (!ArrayUtil.contains(temp, randomNumber)) {
				temp = ArrayUtil.add(temp, randomNumber);
			}
		}

		return temp;
	}

	public static int[] setManualNum() {
		int[] temp = new int[0];
		while (ArrayUtil.size(temp) < lotto_study2.SIZE_MAX) {
			String message = "1부터 45사이의 숫자를 입력해주세요.";

			int userInput = ScannerUtil.nextInt(lotto_study2.sc, message, lotto_study2.NUMBER_MIN,
					lotto_study2.NUMBER_MAX);

			if (ArrayUtil.contains(temp, userInput)) {
				System.out.println("중복된 숫자는 입력할 수 없습니다.");
			} else {
				temp = ArrayUtil.add(temp, userInput);
			}
		}
		
		sort(temp);
		
		return temp;
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < ArrayUtil.size(arr) - 1; i++) {
			if (ArrayUtil.get(arr, i) > ArrayUtil.get(arr, i + 1)) {
				int temp = ArrayUtil.set(arr, i + 1, ArrayUtil.get(arr, i));
				
				ArrayUtil.set(arr, i, temp);
				
				i = -1;
			}
		}
	}
	
	public static void printArray(int[] arr) {
		System.out.println("[");
		for(int i = 0; i < ArrayUtil.size(arr); i++) {
			System.out.printf("%2d", ArrayUtil.get(arr, i));
			if(i != ArrayUtil.size(arr) - 1) {
				System.out.print(" ");
			}
		}
		System.out.println("]");
	}
	
	public static int countSame(int[] arr1, int[] arr2) {
		int count = 0;
		
		for(int i = 0; i < ArrayUtil.size(arr1); i++) {
			if(ArrayUtil.contains(arr2, ArrayUtil.get(arr1, i))) {
				count++;
			}
		}
		
		return count;
	}
}
