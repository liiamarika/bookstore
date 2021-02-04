package fi.hh.swd20.bookstore.domain;

public class Book {

	private String title;
	private String author;
	private String isbn;
	private double price;
	
	
	// constructors
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.price = 0.0;
	}
	
	public Book(String title, String author, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}
	
	
	// setters, getters, toString 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	
	
}
