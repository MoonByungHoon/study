package model;

public class BookStoreDTO {
	private int id, price, amount;
	private String name, author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean equals(Object o) {
		if (o instanceof BookStoreDTO) {
			BookStoreDTO bk = (BookStoreDTO) o;

			return id == bk.id;
		}

		return false;
	}

	public BookStoreDTO() {
		this.name = new String();
		this.author = new String();
	}

	public BookStoreDTO(int id) {
		this.id = id;
		this.name = new String();
		this.author = new String();
	}

	public BookStoreDTO(BookStoreDTO bk) {
		this.id = bk.id;
		this.name = bk.name;
		this.author = bk.author;
		this.amount = bk.amount;
		this.price = bk.price;
	}
}
