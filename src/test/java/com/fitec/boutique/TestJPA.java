package com.fitec.boutique;

import static org.junit.Assert.*;

import java.util.HashSet;
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
import com.fitec.boutique.service.IServiceCategorie;
import com.fitec.boutique.service.IServiceClient;
import com.fitec.boutique.service.IServiceModel;

public class TestJPA {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

	}

	

	@Test
	public void test2() {
		
		try {
			IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
			IServiceCategorie serviceCategorie = (IServiceCategorie) context.getBean("serviceCategorie");
			
			/* // enrigestrer le couple de Model et Categorie
	        Model model1 = new Model("Model A", "rr", "eee");
	        Model model2 = new Model("Model B", "rr", "rr");
	        Model model3 = new Model("Model C", "rff", "ffr");
	       
	        
	        
	        Categorie cat1 = new Categorie("Cat A");
	        Categorie cat2 = new Categorie("Cat B");
			
	        (model1.getCategories()).add(cat1);
	        (model1.getCategories()).add(cat2);
	        
	        (model2.getCategories()).add(cat1);
	        (model2.getCategories()).add(cat2);
	        
	        (model3.getCategories()).add(cat1);
	        (model3.getCategories()).add(cat2);
	        
	        
	        serviceModel.saveModel(model1);
	        serviceModel.saveModel(model2);
	        serviceModel.saveModel(model3);*/
	        
	        // fetch all categorie
	        for(Categorie categorie : serviceCategorie.findAllCategories()) {
	           
	           System.out.println(categorie.getModels());
	        }
	        
	        
			
		} catch (Exception e) {
			
		}
	}
	
	
	@Test
	public void test1() {

		try {

			IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
			IServiceCategorie serviceCategorie = (IServiceCategorie) context.getBean("serviceCategorie");
			
			 for(Model model : serviceModel.findAllModels()) {
		           
		           System.out.println(model.getCategories());
		        }
			
			
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
			
			//List<Model> model3= serviceModel.findAllModels();
			
		//	System.out.println(model3);
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
