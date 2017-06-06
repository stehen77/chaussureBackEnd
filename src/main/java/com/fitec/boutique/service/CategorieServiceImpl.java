package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fitec.boutique.dao.IArticleDao;
import com.fitec.boutique.dao.IDAOCategorie;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Categorie;

@Transactional
public class CategorieServiceImpl implements IServiceCategorie{
	
	private IDAOCategorie daoCategorie;

	
	

	

	@Override
	public Categorie findByName(String name) {
		
		return daoCategorie.findByName(name);
	}

	@Override
	public void saveCategorie(Categorie categorie) {
		daoCategorie.saveCategorie(categorie);
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		daoCategorie.updateCategorie(categorie);
		
	}

	@Override
	public void deleteCategorieById(long id) {
		daoCategorie.deleteCategorieById(id);
		
	}

	// essayer d ecrire
	@Override
	public Categorie findById(long id) {
		List<Categorie> listeCat = daoCategorie.findAllCategories();
		Categorie catSelected = null;
		for (Categorie cat : listeCat){
			if(cat.getId_categorie() == id){
				cat.getModels().size();
				catSelected = cat;
			}
		}
		return catSelected;
	}
	
	@Override
	public List<Categorie> findAllCategories() {
		List<Categorie> listeCat = daoCategorie.findAllCategories();
		for (Categorie cat : listeCat){
			 cat.getModels().size(); //appeler .size() sur une collection "lazy" dans 
			                          //une méthode @Transactional remonte tout de suite val en memoire
			                         //--> pas de lazy exception coté web
		}
		return listeCat;
	}

	/*@Override
	public List<Categorie> findAllCategories() {
		return daoCategorie.findAllCategories();
	}*/
	
	@Override
	public boolean isCategorieExist(Categorie categorie) {
		
		return daoCategorie.isCategorieExist(categorie);
	}

	public IDAOCategorie getDaoCategorie() {
		return daoCategorie;
	}

	public void setDaoCategorie(IDAOCategorie daoCategorie) {
		this.daoCategorie = daoCategorie;
	}
	
	
	
	

}
