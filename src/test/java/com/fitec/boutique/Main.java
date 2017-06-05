package com.fitec.boutique;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.service.IServiceModel;

public class Main {

	public static void main(String[] args) {
		
		/*//IServiceModel serviceModel = (IServiceModel) context.getBean("serviceModel");
		
		
		
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
					serviceModel.saveModel(model2);
					
					List<Model> model3= serviceModel.findAllModels();
					
					System.out.println(model3);
		
		
		
		*/
	}

}
