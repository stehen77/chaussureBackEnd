package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  ligne_de_commande.java
 * Author:  Fitec
 * Purpose: Defines the Class ligne_de_commande
 ***********************************************************************/

import java.util.*;

public class Ligne_de_commande {

	private long id_ligne_cmde;

	private int quantite;

	public Ligne_de_commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ligne_de_commande(int quantite) {
		super();
		this.quantite = quantite;
	}

	public long getId_ligne_cmde() {
		return id_ligne_cmde;
	}

	public void setId_ligne_cmde(long id_ligne_cmde) {
		this.id_ligne_cmde = id_ligne_cmde;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Ligne_de_commande [id_ligne_cmde=" + id_ligne_cmde + ", quantite=" + quantite + "]";
	}

}