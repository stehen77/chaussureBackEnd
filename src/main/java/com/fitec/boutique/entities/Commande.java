package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  commande.java
 * Author:  Fitec
 * Purpose: Defines the Class commande
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="commande")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Commande implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private long id_commande;

	@Column(name="date")
	private java.util.Date date;

	@Column(name="adresse_livraison")
	private String adresse_livraison;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	//@JsonIgnore
	private Client client;
	
	@OneToMany
	@JoinColumn(name="id_ligne_cmde")
	//@JsonIgnore
	private Collection<Ligne_de_commande> ligne_de_commandes;

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<Ligne_de_commande> getLigne_de_commandes() {
		return ligne_de_commandes;
	}

	public void setLigne_de_commandes(Collection<Ligne_de_commande> ligne_de_commandes) {
		this.ligne_de_commandes = ligne_de_commandes;
	}
	
	

}