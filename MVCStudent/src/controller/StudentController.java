package controller;

import java.util.ArrayList;
import model.StudentDTO;

public class StudentController {
	private ArrayList<StudentDTO> list;
	private int nextId;
	
	public StudentController() {
		list = new ArrayList<>();
		nextId = 1;
	}
	
	public void insert(StudentDTO st) {
		st.setId(nextId++);
//		st에 id값을 부여한 후에 nextId에 대한 값을 1증가.
		list.add(st);
//		st에 대한 model을 되돌려주지만 id값만 변경.
	}
	
	public ArrayList<StudentDTO> selectAll() {
		ArrayList<StudentDTO> temp = new ArrayList<>();
		
		for(StudentDTO st : this.list) {
			temp.add(new StudentDTO(st));
		}
		
		return temp;
	}
	
	public StudentDTO selectOne(int id) {
//		특정 id값을 받아 온 후에 비교하는 것이다.
		for(StudentDTO st : list) {
			if(st.getId() == id) {
//				list 배열을 차례대로 옮겨서 같은 타입으로 선언된 st에 옮겨 담은 후에
//				매 반복당 id값이 같은 대상을 찾는다. 이후 해당 값을 발견하면
//				해당 배열을 리턴한다.
				return new StudentDTO(st);
//				그냥 st를 넘겨도 되나 당장 db가 없으므로 혹시 모를 원본을 손상시키지 않기 위해 캡슐화 시킴.
			}
		}
		
		return null;
	}
	
	public void update(StudentDTO st) {
		list.set(list.indexOf(st), st);
//		indexOf에 넘어가는 해당 element와 같은 값을 가진 배열을 찾아서 해당 배열의 인덱스 값을 리턴해준다.
//		이후 set 함수에서 해당 인덱스 위치에 st값을 집어넣는다. 즉 이런 방식으로 수정됨.
	}
	
	public void delete(int id) {
		list.remove(new StudentDTO(id));
//		넘겨 받는 id값을 받는 생성자를 호출하여서 새로운 인스턴스를 생성해서 같은 타입으로 만든다.
//		이후 해당 타입의 id값과 동일한 값을 가진 list내의 배열을 찾아 삭제하게 된다.
	}
}
