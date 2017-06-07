package com.fitec.boutique;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.fitec.boutique.entities.Article;
import com.fitec.boutique.service.IServiceArticle;
import com.fitec.boutique.service.IServiceCategorie;
import com.fitec.boutique.service.IServiceModel;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping(value="/acceuil")
public class HomeController {
	@Autowired
	private IServiceArticle metierArticle;
	
	@Autowired
	private IServiceModel metierModel;
	
	@Autowired
	private IServiceCategorie metierCategorie;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		// creration de formulaire
		
				model.addAttribute("article", new Article());
				model.addAttribute("model", new com.fitec.boutique.entities.Model());
				model.addAttribute("categorie", new com.fitec.boutique.entities.Categorie());
				model.addAttribute("articles", metierArticle.findAllArticles());
				model.addAttribute("models", metierModel.findAllModels());
				model.addAttribute("categories", metierCategorie.findAllCategories());
				
		return "home";
	}
	
	
	
}
