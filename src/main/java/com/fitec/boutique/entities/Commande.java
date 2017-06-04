package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  commande.java
 * Author:  Fitec
 * Purpose: Defines the Class commande
 ***********************************************************************/

import java.util.*;

public class Commande {

	private long id_commande;

	private java.util.Date date;

	private String adresse_livraison;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Date date, String adresse_livraison) {
		super();
		this.date = date;
		this.adresse_livraison = adresse_livraison;
	}

	public long getId_commande() {
		return id_commande;
	}

	public void setId_commande(long id_commande) {
		this.id_commande = id_commande;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getAdresse_livraison() {
		return adresse_livraison;
	}

	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}

	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", date=" + date + ", adresse_livraison=" + adresse_livraison
				+ "]";
	}

}