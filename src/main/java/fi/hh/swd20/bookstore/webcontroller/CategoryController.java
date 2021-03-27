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


import fi.hh.swd20.bookstore.domain.Category;
import fi.hh.swd20.bookstore.domain.CategoryRepository;

//muista tämä annotaatio
@CrossOrigin
@Controller
public class CategoryController {

		// Spring-alusta luo sovelluksen käynnistyessä CategoryRepository-rajapintaa toteuttavan luokan olion ja kytkee 
		// olion CategoryController-luokasta luodun olion attribuuttiolioksi, jotta on repository olio jonka metodeja voidaan kutsua
		
		@Autowired
		private CategoryRepository categoryrepository;

		// RESTful service to get all categories
	    @RequestMapping(value="/categories", method = RequestMethod.GET)
	    public @ResponseBody List<Category> getCategoriesRest() {	
	        return (List<Category>) categoryrepository.findAll();
	    }    

		// RESTful service to get category by id
	    @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryid) {	
	    	return categoryrepository.findById(categoryid);
	    } 
		
		
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
