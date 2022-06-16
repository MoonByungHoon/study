package day0616;
	
public class Student2 {
		public final int SUBJECT_SIZE = 3;
	
		private int id;
		private String name;
		private int kor;
		private int eng;
		private int math;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int calculateSum() {
			return kor + eng + math;
		}
		
		public double calculateAverage() {
			return (double)calculateSum() / SUBJECT_SIZE;
		}
		
		public Student2(int id, String name, int kor, int eng, int math) {
			this.id = id;
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		public Student2() {
			this.id = -1;
			this.name = "아직 입력 안됨";
			this.kor = -1;
			this.eng = -1;
			this.math = -1;
		}
		
		public boolean equals(Object o) {
			if(o instanceof Student) {
				Student s = (Student) o;
				
				return id == s.id;
			}
			
			return false;
		}
		
		public void printInfo() {
			System.out.printf("번호 : %d번 이름 : %s\n", this.id, this.name);
			System.out.printf("국어 : %03d점 영어 : %03d 수학 : %03d\n", this.kor, this.eng, this.math);
			System.out.printf("총점 : %03d점 평균 : %06.2f점\n", calculateSum(), calculateAverage());
		}
		
		public String toString() {
			
			return "id : " + this.id + " name : " + this.name + "\n kor : " + this.kor + "eng : " + this.eng + "math" + this.math;		}
}