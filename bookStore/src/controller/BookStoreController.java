package controller;

import java.util.ArrayList;

import model.BookStoreDTO;

public class BookStoreController {
	private ArrayList<BookStoreDTO> book;
	private int bookCount;

	public BookStoreController() {
		book = new ArrayList<>();
		bookCount = 1;
	}

	public void insert(BookStoreDTO bk) {
		if(!validateBookName(bk.getName())) {
			bk.setId(bookCount++);

			this.book.add(bk);
		} else {
			System.out.println("중복된 책입니다. 수정을 이용해주시길 바랍니다.");
		}
	}

	public ArrayList<BookStoreDTO> bookStoreAll() {
		ArrayList<BookStoreDTO> temp = new ArrayList<>();

		for (BookStoreDTO bk : book) {
			temp.add(new BookStoreDTO(bk));
//			 생성자를 만들어둔게 있어서 깊은 복사가 가능하다.
		}

		return temp;
	}

	public BookStoreDTO selectOne(int id) {
		for (BookStoreDTO bk : book) {
			if (bk.getId() == id) {

				return new BookStoreDTO(bk);
//				역시나 생성자가 있어서 해당 값을 받아서 새로운 객체로 넘김.
//				즉 깊은 복사로 넘김.
			}
		}

		return null;
	}

	public void update(BookStoreDTO bk) {
		book.set(book.indexOf(bk), bk);
	}

	public void delete(int id) {
		book.remove(new BookStoreDTO(id));
	}
	
	public boolean validateBookName(String name) {
		for(BookStoreDTO bk : book) {
			if(bk.getName().equalsIgnoreCase(name)) {
				
				return true;
			}
		}
		
		return false;
	}
}
