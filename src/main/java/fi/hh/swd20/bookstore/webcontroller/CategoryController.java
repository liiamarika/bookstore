package fi.hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

		// Spring-alusta luo sovelluksen käynnistyessä CategoryRepository-rajapintaa toteuttavan luokan olion ja kytkee 
		// olion CategoryController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
		
		@Autowired
		private CategoryRepository categoryrepository;

		// tuottaa listan kategorioista
		@RequestMapping(value = "/categorylist")
		public String categoryList (Model model) {
			model.addAttribute("categories", categoryrepository.findAll());
			return "categorylist";
		}
		
		// lisätään uusi kategoria lomakkeelta
		@RequestMapping(value = "/createcategory")
		public String createCategory (Model model) {
			model.addAttribute("category", new Category());
			return "createcategory";
		}
		
		// tallennetaan kategoria kantaan
		@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
		public String save (Category category) {
			categoryrepository.save(category);
			return "redirect:categorylist";
		}
		
		
		
		
}
