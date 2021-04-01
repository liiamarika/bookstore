package fi.hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;
import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)  // JUnit5
@DataJpaTest
public class BookstoreRepositoryTest {

	
	 @Autowired
	    private BookRepository bookRepository;
	    
	 @Autowired
	 	private CategoryRepository categoryRepository;
	 
	// testataan BookRepositoryn save-metodia
	 @Test 
	    public void createNewBook() {
	    	Book book = new Book("Leijat Helsingin yllä", "Kjell Westö", "988776", 12.90, null);
	    	bookRepository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }   

	// testataan CategoryRepositoryn save-metodia
	 @Test 
	    public void createNewCategory() {
	    	Category category = new Category("Poems");
	    	categoryRepository.save(category);
	    	assertThat(category.getCategoryid()).isNotNull();
	    }  
	 
	// testataan BookRepositoryn findByTitle-metodin toimivuutta
	 @Test  
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = bookRepository.findByTitle("Wuthering Heights");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("Emily Bronte");
	    }
	    
	// testataan CategoryRepositoryn findByName-metodin toimivuutta
		 @Test  
		    public void findByNameShouldReturnCategory() {
		        List<Category> categories = categoryRepository.findByName("Crime");
		        
		        assertThat(categories).hasSize(1);
		        assertThat(categories.get(0).getName()).isEqualTo("Crime");
		    }
	
		 // delete puuttuu, muuten ok
	
		    
}
