package day0616;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ex04Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		
//		1. 리스트에 중복되지 않은 숫자 추가하기
		while(list.size() < 6) {
			int num = random.nextInt(45) + 1;
			
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		
//		2. 정렬하기
		Collections.sort(list);
		
//		3. 출력하기
		System.out.println(list);
		
		
	}
}
