package controller;

import java.util.ArrayList;
import model.BoardDTO;
//컨트롤러는 데이터 베이스로부터 값을 받아서 뷰어에 뿌려줄 값을 객체의 형태로 보내주거나
//뷰어에서 입력받은 값을 객체의 형태로 받아서 데이터 베이스로 보내주는 중간다리 역할을 맡는
//클래스이다.

//단, 지금 코딩에는 데이터 베이스가 없기 때문에 유사 데이터 베이스의 역할을 해줄 ArrayList<BoardDTO>를
//필드로 하나 만들었다.

public class BoardController {
	private ArrayList<BoardDTO> list;
	private int nextId;

	public BoardController() {
		list = new ArrayList<>();
		nextId = 1;

//		for(int i = 1; i <= 4; i++) {
//			BoardDTO b = new BoardDTO();
//			b.setTitle("제목 : " + i);
//			b.setWriter("작성자 : " + i);
//			b.setContent("내용 : " + i);
//			
//			insert(b);
//		}
	}

//	뷰어에서 보낸 BoardDTO 객제에 id를 추가한 후 list에 저장하는 insert()
	public void insert(BoardDTO b) {
		b.setId(nextId++);
		list.add(b);
	}

//	뷰어에 출력할 게시글 리스트를 원본에서 딥 카피한 버전을 보내줄 selectAll();
	public ArrayList<BoardDTO> selectAll() {
		ArrayList<BoardDTO> temp = new ArrayList<>();

		for (BoardDTO b : this.list) {
			temp.add(new BoardDTO(b));
		}

		return temp;
	}

//	특정 아이디 값을 가진 BoardDTO 객체를 리턴하는 selectOne()
//	단, 해당 id값이 존재하지 않는다면 null을 리턴
	public BoardDTO selectOne(int id) {
		for (BoardDTO b : list) {
			if (b.getId() == id) {

				return new BoardDTO(b);
			}
		}

		return null;
	}

//	리스트의 특정 객체를 수정하는 update()
	public void update(BoardDTO b) {
		list.set(list.indexOf(b), b);
	}

//	리스트의 특정 객체를 삭제하는 delete()
	public void delete(int id) {
		list.remove(new BoardDTO(id));
	}
}
