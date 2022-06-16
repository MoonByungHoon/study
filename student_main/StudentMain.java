package student_main;

import struct.Student;

public class StudentMain {
//	구조체 사용하기
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//			직접 만든 데이터 타입의 변수를 만들 때에는 해당 형태를 변수가 가지게 된다.

        Student s = new Student();

//		해당 변수의 내부 공간에 접근할 때에 (변수이름.공간이름)으로 접근할 수 있다.
//		즉 Student 변수 s의 id에 3을 저장하라는 명령은 다음과 같다.

        s.id = 3;
        s.name = "문병훈";
        s.kor = 80;
        s.eng = 80;
        s.math = 81;

//		저장된 값을 호출할 때에도 똑같이 적어준다.
//		.은 of로 생각하면 편하다.

        System.out.println("s.id : " + s.id);
        System.out.println("s.name : " + s.name);

        int sum = s.kor + s.eng + s.math;
        double average = sum / 3.0;

        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + average);

        Student s2 = new Student();

        s2.id = 1;
        s2.name = "고길동";
        s2.kor = 90;
        s2.eng = 91;
        s2.math = 91;

        System.out.println("s.id : " + s.id);
        System.out.println("s2.id : " + s2.id);

//		해당 데이터 타입으로 배열도 선언이 가능하다.

        Student[] arr = new Student[3];

//		단 각 배열 공간마다 개별적으로 초기화 시켜줘야한다.
//		아래가 초기화를 시켜준 것이다.
        arr[0] = new Student();
//		내부 공간에 데이터 타입에 따라 기본형이면 0, 참조형이면 null로 초기화가 된다.

        System.out.println("arr[0].id : " + arr[0].id);
        System.out.println("arr[0].name : " + arr[0].name);
//		null 반환

//		주의할 점은 우리가 참조형 데이터 타입의 공간끼리 실제 값을 비교할 때에는
//		equals()를 사용해아 한다고 알고 있지만 지금 만든 데이터 타입에서는 필요가 없다.
//		s2와 같은 s3을 만들고 비교해보자.

        Student s3 = new Student();

        s3.id = 1;
        s3.name = "고길동";
        s3.kor = 90;
        s3.eng = 91;
        s3.math = 91;

        System.out.println("s2.equals(s3) : " + s2.equals(s3));
//		false 반환

//		따라서 직접 equals를 만들어주거나 아니면 두 공간의 특정 값을 직접 비교하게 해야한다.

        System.out.println("s2 == s3 : " + (s2 == s3));
//		false 반환

        System.out.println("s2.id == s3.id : " + (s2.id == s3.id));
//		true 반환

    }
}
