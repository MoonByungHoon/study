package day0616;

//	학생 클래스
//	필드 : 번호, 이름, 국어, 영어, 수학
//	메소드 : 총점계산, 평균계산, 정보출력, equals(), 오버라이드
	
public class Student {
//	필드
		public final int SUBJECT_SIZE = 3;
	
		public int id;
		public String name;
		public int kor;
		public int eng;
		public int math;
		
//	메소드
		
		public int calculateSum() {
			return kor + eng + math;
		}
		
		public double calculateAverage() {
			return (double)calculateSum() / SUBJECT_SIZE;
		}
		
//		생성자
//		1. 파라미터가 있는 생성자.
		public Student(int id, String name, int kor, int eng, int math) {
			this.id = id;
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
//		2. 파라미터가 없는 생성자.
		public Student() {
			this.id = -1;
			this.name = "아직 입력 안됨";
			this.kor = -1;
			this.eng = -1;
			this.math = -1;
		}
		
//		3. equals() 오버라이드
		public boolean equals(Object o) {
//		파라미터로 들어온 Object라는 객체가 실화가 끝난 Student 클래스의 인스턴스인지를 instanceof라는 키워드를 통해서
//		체크하고 맞으면 추가적인 코드를 진행한다.
			
			if(o instanceof Student) {
				Student s = (Student) o;
				
				return id == s.id;
			}
			
			
			return false;
		}
		
//		4. 정보 출력 메소드
		
		public void printInfo() {
			System.out.printf("번호 : %d번 이름 : %s\n", this.id, this.name);
			System.out.printf("국어 : %03d점 영어 : %03d 수학 : %03d\n", this.kor, this.eng, this.math);
			System.out.printf("총점 : %03d점 평균 : %06.2f점\n", calculateSum(), calculateAverage());
			
		}
}