package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fitec.boutique.dao.IDAOCommande;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Commande;

@Transactional
public class CommandeServiceImpl implements IServiceCommande{

	@Autowired
	private IDAOCommande daoCommande;
	
	public IDAOCommande getDaoCommande() {
		return daoCommande;
	}

	public void setDaoCommande(IDAOCommande daoCommande) {
		this.daoCommande = daoCommande;
	}

	@Override
	public List<Commande> findAllCommandes() {
		List<Commande> listeCom = daoCommande.findAllCommandes();
		for (Commande com : listeCom){
			 com.getLigne_de_commandes().size(); //appeler .size() sur une collection "lazy" dans 
			                          //une méthode @Transactional remonte tout de suite val en memoire
			                         //--> pas de lazy exception coté web
		}
		return listeCom;
	}

	@Override
	public Commande findById(long id) {
		List<Commande> listeCom = daoCommande.findAllCommandes();
		Commande comSelected = null;
		for (Commande com : listeCom){
			if(com.getId_commande() == id){
				com.getLigne_de_commandes().size();
				comSelected = com;
			}
		}
		return comSelected;
	}

	@Override
	public void saveCommande(Commande commande) {
		// TODO Auto-generated method stub
		daoCommande.saveCommande(commande);
		
	}

	@Override
	public void updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		daoCommande.updateCommande(commande);
	}

	@Override
	public void deleteCommandeById(long id) {
		// TODO Auto-generated method stub
		daoCommande.deleteCommandeById(id);
	}

	
	@Override
	public boolean isCommandeExist(Commande commande) {
		// TODO Auto-generated method stub
		return daoCommande.isCommandeExist(commande);
	}

}
