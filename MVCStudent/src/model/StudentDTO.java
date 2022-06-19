package model;

public class StudentDTO {
	private final int SUBJECK_SIZE = 3;
	private int id, kor, eng, math;
	private String name;
	
	public int getSUBJECK_SIZE() {
		return SUBJECK_SIZE;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public boolean equals (Object o) {
		 if(o instanceof StudentDTO) {
			 StudentDTO b = (StudentDTO) o;
			 
			 return id == b.id;
		 }
		 
		 return false;
	 }
	 
	 public StudentDTO() {
		 this.name = new String();
	 }
	 
	 public StudentDTO(int id) {
		 this.id = id;
		 this.name = new String();
	 }
	 
	 public StudentDTO(StudentDTO origin) {
		 this.id = origin.id;
		 this.name = origin.name;
		 this.kor = origin.kor;
		 this.eng = origin.eng;
		 this.math = origin.math;
	 }
}
