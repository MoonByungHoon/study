package day0616;
//ArrayList 객체는 반드시 해당 객체가 어떤 클래스 객체의 모음인지 적어주어야한다.
//그래서 ArrayList<클레스이름> 객체이름 = new ArrayList<>();로 선언한다.
//<> 이러한것을 템플릿이라고 한다.

import java.util.Random;
import java.util.ArrayList;

public class Ex03ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer 클래스를 모아둔 ArrayList를 만들기
		
		ArrayList<Integer> list = new ArrayList<>();
		
//		1. 해당 배열에 객체가 존재하는지 확인하고 싶다면.
		System.out.println("isEmpty() : " + list.isEmpty());
		
//		2. 해당 배열에 객체가 몇개 존재하는지 알고 싶다면.
		System.out.println("size() : " + list.size());
		
//		Integer 객체의 초기화는 int 값으로도 가능하다.
		Integer i1 = 1;
		Integer i2 = 2;
		int num3 = 3;
		Integer i3 = num3;
		Integer i4 = new Integer(6);
		
//		3.해당 배열에 가장 마지막에 새로운 요소를 추가하고 싶다면.
		
		list.add(i1);
		list.add(i2);
		list.add(2);
		list.add(num3);
		list.add(i3);
		
		System.out.println("add 후 size() : " + list.size());
		
//		4. 리스트에 특정 인덱스 값이 저장된 객체를 불러오고 싶다면
		System.out.println("get(1) : " + list.get(1));
		
//		5. 리스트 내의 특정 위치에 새로운 값을 끼워넣고 싶다면
		list.add(1, 200);
		
		System.out.println("get(1) : " + list.get(1));
		
//		6. 리스트 내의 특정 인덱스 값을 삭제하고 싶다면
		list.remove(1);
		
		System.out.println("get(1) : " + list.get(1)); 
		
//		7. 리스트의 전체 내용을 삭제하고 싶다면
		list.clear();
		
		System.out.println("isEmpty() : " + list.isEmpty());
		
//			아래의 메소드들은 정확한 결과를 받기 위해서는 반드시 해당 클래스 안에 equals() 메소드가
//			정확하게 오버라이딩 되어 있어야한다.
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
//	8.	특정 요소가 리스트에 존재하는지 알고 싶다면
		System.out.println("contains(i2) : " + list.contains(i2));
		System.out.println("contains(i4) : " + list.contains(i4));
		
	}
}
