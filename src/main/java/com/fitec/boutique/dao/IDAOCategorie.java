package com.fitec.boutique.dao;

import java.util.List;

import com.fitec.boutique.entities.Categorie;


public interface IDAOCategorie {

	
	public Categorie findById(long id);

	public Categorie findByName(String name);

	public void saveCategorie(Categorie categorie);

	public void updateCategorie(Categorie categorie);

	public void deleteCategorieById(long id);

	public List<Categorie> findAllCategories();
	
	boolean isCategorieExist(Categorie categorie);
}
