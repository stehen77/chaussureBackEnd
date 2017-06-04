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
	public Categorie findById(long id) {
		
		return daoCategorie.findById(id);
	}

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

	@Override
	public List<Categorie> findAllCategories() {
		
		return daoCategorie.findAllCategories();
	}

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
