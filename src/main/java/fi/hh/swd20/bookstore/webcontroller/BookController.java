package fi.hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.bookstore.domain.Book;
import fi.hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	// Spring-alusta luo sovelluksen käynnistyessä BookRepository-rajapintaa toteuttavan luokan olion ja kytkee 
	// olion BookController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
	@Autowired
	private BookRepository repository;

	// tuottaa listan kirjoista
	@RequestMapping(value = "/booklist")
	public String bookList (Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// lisätään kirja lomakkeelta
	@RequestMapping(value = "/add")
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	// tallennetaan kirja kantaan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save (Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	// poistetaan kirja idn perusteella
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete (@PathVariable(value= "id") long id) {
		repository.deleteById(id);
		return "redirect:/booklist";
	}
	
	// haetaan muokattava kirja idn perusteella lomakkeelle
	@RequestMapping(value = "/edit/{id}")
	public String edit (@PathVariable(value="id") long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}
	
}
