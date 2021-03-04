package fi.hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	// constructors
	
	public Book() {}
	
	public Book(String title, String author, String isbn, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	
	// setters, getters, toString 	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", category=" + this.getCategory() + "]";
		else 
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price + "]";
	}

	
	
	
	
	
}
