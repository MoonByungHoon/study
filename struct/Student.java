package struct;
//구조체에 대해서 설명하자면 우리가 필요한 데이터 타입을 직접 만들어준 우리만의 데이터 타입이다.
//abstract원래대로라면 우리가 직접 struct라는 키워드를 사용해서 구조체를 만들어야하지만
//해당 문법은 자바에 존재하지 않으므로 별개의 클래스를 만들어서
//그 안에 어떤 종류의 정보가 해당 데이터 타입의 변수 혹은 상수에 저장될 지를 지정한다.
public class Student {
	public int id, kor, eng, math;
	public String name;
}
