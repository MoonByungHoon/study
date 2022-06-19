package main;

import viewer.StudentViewer;
//1번. 학생 관리 시스템을 MVC 패턴으로 구축하시오.
//2번. 사용자 관리 시스템을 만드시오.
//단, 회원 가입시에 동일한 아이디는 생성 불가.
//3. 사원 관리 시스템을 MVC로 구축하시오.

public class Studentmain {

	public static void main(String[] args) {
		StudentViewer stViewer = new StudentViewer();
		stViewer.showStudent();
	}
}
