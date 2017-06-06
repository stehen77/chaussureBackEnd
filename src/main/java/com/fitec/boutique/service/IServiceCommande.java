package com.fitec.boutique.service;

import java.util.List;

import com.fitec.boutique.entities.Commande;

public interface IServiceCommande {

	public Commande findById(long id);

	

	public void saveCommande(Commande commande);

	public void updateCommande(Commande commande);

	public void deleteCommandeById(long id);

	public List<Commande> findAllCommandes();
	
	boolean isCommandeExist(Commande commande);
	
}
