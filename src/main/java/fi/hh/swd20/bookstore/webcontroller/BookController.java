package fi.hh.swd20.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;
import fi.hh.swd20.bookstore.domain.CategoryRepository;

//muista tämä annotaatio
@CrossOrigin
@Controller
public class BookController {
	
	// Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa toteuttavan luokan olion ja kytkee 
	// olion BookController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private CategoryRepository categoryrepository;

	
	
	// RESTful service to get all books
    // java-kielinen book luokan oliolistan pohjalta tuotetaan json-kirjaolijalistaksi
    // ja lähetetään web-selaimelle  vastauksena el responsen bodyna
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> booktListRest() {	
        return (List<Book>) bookrepository.findAll();
    }   
    
    // RESTful service to get book by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
    	return bookrepository.findById(id);
    } 
    
    
    
	// tuottaa listan kirjoista
		@RequestMapping(value = "/booklist")
		public String bookList (Model model) {
			model.addAttribute("books", bookrepository.findAll());
			return "booklist";
		}
	
		
	// lisätään kirja lomakkeelta
	@RequestMapping(value = "/addbook")
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		// dropdown valikon kategoriat
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}
	
	// tallennetaan kirja kantaan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save (Book book) {
		bookrepository.save(book);
		return "redirect:booklist";
	}
	
	// poistetaan kirja idn perusteella
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete (@PathVariable(value= "id") long id) {
		bookrepository.deleteById(id);
		return "redirect:/booklist";
	}
	
	// haetaan muokattava kirja idn perusteella lomakkeelle
	@RequestMapping(value = "/edit/{id}")
	public String edit (@PathVariable(value="id") long id, Model model) {
		model.addAttribute("book", bookrepository.findById(id));
		return "editbook";
	}
	
}
