package fi.hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;
import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;
import fi.hh.swd20.bookstore.domain.User;
import fi.hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner bookstoreDemo (CategoryRepository categoryrepository, BookRepository bookrepository, UserRepository userrepository) {
		return (args) -> {
			// luodaan testidataan kategoriat
			log.info("save a couple of categories");
			Category category1 = new Category("Fantasy");
			categoryrepository.save(category1);
			Category category2 = new Category("Romance");
			categoryrepository.save(category2);
			Category category3 = new Category("Crime");
			categoryrepository.save(category3);
			
			// luodaan testidataan kirjat
			log.info("save couple of demo books");
			Book book1 = new Book("Pride and Prejudice", "Jane Austen", "123456", 19.90, category2);
			bookrepository.save(book1);
			Book book2 = new Book("Wuthering Heights", "Emily Bronte", "234567", 11.90, category2);
			bookrepository.save(book2);
			Book book3 = new Book("Harry Potter and the prisoner of Azkaban", "J.K. Rowling", "456789", 11.90, category1);
			bookrepository.save(book3);
			
			// luodaan testikäyttäjiä
			log.info("save couple of users");
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.fi", "USER");
			userrepository.save(user1);
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");
			userrepository.save(user2);
			User user3 = new User("liia", "$2a$10$eLgmttXgTYdiq3ieqTXR8OBKWgdF/AERV6DoG84GjmrD/LQ30CKRy", "liia@liia.fi", "ADMIN");
			userrepository.save(user3);
			
			log.info("Fetch all the books");
			for (Book book : bookrepository.findAll()) {
			   log.info(book.toString());
			}
			
			log.info("Fetch all the categories");
			for (Category category : categoryrepository.findAll()) {
			   log.info(category.toString());
			}
			
			log.info("Fetch all the users");
			for (User user : userrepository.findAll()) {
			   log.info(user.toString());
			}
			
		};
		
	}

}
