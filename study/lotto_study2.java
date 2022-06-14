package study;

import java.util.Random;
import java.util.Scanner;
import util.ScannerUtil;
import util.ArrayUtil;

public class lotto_study2 {
	static Scanner sc = new Scanner(System.in);
	static final int SIZE_MAX = 6;
	static final int NUMBER_MIN = 1;
	static final int NUMBER_MAX = 45;
//	사용자로부터 몇 게임을 할지 입력 받기.
//	각 게임마다 수동 자동 입력받기
//	결과 보여주는 프로그램 작성
//	
//	1. util들 사용하기
//	2. 자동 숫자 부여 메소드 만들기
//	3. 정렬을 별개의 메소드로 구성
//	4. 결과 비교를 별개의 메소드로 구성
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String message = "총 몇게임 하시겠습니까?";
		
		int gameNumber = ScannerUtil.nextInt(sc, message);
		
		int[][] userNumbers = new int[gameNumber][];
		
		for(int i = 0; i < userNumbers.length; i++) {
			System.out.printf("%d번째 게임\n", i + 1);
			
			message = "1.자동 2.수동";
			
			int userChoice = ScannerUtil.nextInt(sc, message);
			
			if(userChoice == 1) {
				userNumbers[i] = lotto_study2_sub.setAutoNum();
			} else {
				userNumbers[i] =lotto_study2_sub.setManualNum();
			}
		}
		
		int[] computerNumbers = lotto_study2_sub.setAutoNum();
		
		System.out.println("-------------------------");
		System.out.println("컴퓨터 숫자");
		System.out.println("-------------------------");
		
		lotto_study2_sub.printArray(computerNumbers);
		
		System.out.println();
		
		System.out.println("-------------------------");
		System.out.println("사용자 숫자");
		System.out.println("-------------------------");
		
		for(int i = 0; i < userNumbers.length; i++) {
			lotto_study2_sub.printArray(computerNumbers[i]);
			
			System.out.println("총 맞은 갯수 : " + lotto_study2_sub.countSame
					(computerNumbers, computerNumbers[i]));
		}
		
		sc.close();
	}
}