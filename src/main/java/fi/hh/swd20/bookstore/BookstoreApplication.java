package fi.hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner bookstoreDemo (BookRepository repository) {
		return (args) -> {
			log.info("save couple of demo books");
			repository.save(new Book("Pride and Prejudice", "Jane Austen", "123456", 19.90));
			repository.save(new Book("Wuthering Heights", "Emily Bronte", "234567", 11.90));
			
		};
		
	}

}
