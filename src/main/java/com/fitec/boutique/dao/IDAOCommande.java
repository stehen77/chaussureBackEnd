package com.fitec.boutique.dao;

import java.util.List;

import com.fitec.boutique.entities.Commande;
import com.fitec.boutique.entities.Ligne_de_commande;

public interface IDAOCommande {

	
	public Commande findById(long id);

	

	public void saveCommande(Commande commande);
	public void saveLigneCommande(Ligne_de_commande ligneCommande);

	public void updateCommande(Commande commande);

	public void deleteCommandeById(long id);

	public List<Commande> findAllCommandes();
	
	boolean isCommandeExist(Commande commande);
}
