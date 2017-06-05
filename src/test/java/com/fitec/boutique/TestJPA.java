package com.fitec.boutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.service.IServiceAdmin;

import com.fitec.boutique.service.IServiceClient;
import com.fitec.boutique.service.IServiceModel;

public class TestJPA {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

	}

	/*
	 * @Test public void test1() {
	 * 
	 * try {
	 * 
	 * 
	 * 
	 * IServiceAdmin service = (IServiceAdmin) context.getBean("service");
	 * 
	 * List<Admin> admin1 = service.findAllAdmins(); service.saveAdmin(new
	 * Admin("nom_admin", "prenom_admin", "admin@admin0fr"));
	 * service.saveAdmin(new Admin("nom_admin1", "prenom_admin1",
	 * "admin1@admin.fr")); service.saveAdmin(new Admin("nom_admin2",
	 * "prenom_admin2", "admin2@admin.fr"));
	 * 
	 * 
	 * 
	 * List<Admin> admin2 = service.findAllAdmins();
	 * assertTrue(admin1.size()+2==admin2.size()); } catch (Exception e) {
	 * assertTrue(e.getMessage(),false); } }
	 */

	/*@Test
	public void test1() {

		try {

			IServiceArticle service = (IServiceArticle) context.getBean("service");

			List<Article> article1 = service.findAllArticles();
			service.saveArticle(new Article(2.5, 52, 10, (new Model("aaa", "hhhhhhhh", "yh"))));
			
			

			List<Article> article2 = service.findAllArticles();
			assertTrue(article1.size() + 2 == article2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
	
	@Test
	public void test1() {

		try {

			IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
/*
			Categorie categorie1 = new Categorie();
			categorie1.setNom_cat("Homme1");

			Categorie categorie2 = new Categorie();
			categorie2.setNom_cat("Femme1");
			
			
			Model model1 = new Model();
			model1.setNom_model("Chaussure Adidas");
			(model1.getCategories()).add(categorie2);
			

			Model model2 = new Model();
			model2.setNom_model("Chaussure assisc");
			(model2.getCategories()).add(categorie1);
			
			serviceModel.saveModel(model1);
			serviceModel.saveModel(model2);*/
			
			List<Model> model3= serviceModel.findAllModels();
			
			System.out.println(model3);
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
