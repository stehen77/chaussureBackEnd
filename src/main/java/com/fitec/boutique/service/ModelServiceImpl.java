package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fitec.boutique.dao.IDAOModel;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Model;

@Transactional
public class ModelServiceImpl implements IServiceModel{

	private IDAOModel daoModel;
	
	@Override
	public Model findById(long id) {
		
		return daoModel.findById(id);
	}

	@Override
	public Model findByName(String name) {
		
		return daoModel.findByName(name);
	}

	@Override
	public void saveModel(Model model) {
		daoModel.saveModel(model);
		
	}

	@Override
	public void updateModel(Model model) {
		daoModel.updateModel(model);
		
	}

	@Override
	public void deleteModelById(long id) {
		daoModel.deleteModelById(id);
		
	}

	/*@Override
	public List<Model> findAllModels() {
		
		List<Model> listeModl = daoModel.findAllModels();
		for (Model mod : listeModl){
			mod.getCategories().size(); //appeler .size() sur une collection "lazy" dans 
			                          //une méthode @Transactional remonte tout de suite val en memoire
			                         //--> pas de lazy exception coté web
		}
		return listeModl;
	}*/
	
	@Override
	public List<Model> findAllModels() {
		
		
		return daoModel.findAllModels();
	}

	@Override
	public boolean isModelExist(Model model) {
		
		return daoModel.isModelExist(model);
	}

	public IDAOModel getDaoModel() {
		return daoModel;
	}

	public void setDaoModel(IDAOModel daoModel) {
		this.daoModel = daoModel;
	}

	
}
