package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  article.java
 * Author:  Fitec
 * Purpose: Defines the Class article
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="article")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article")
	private long id_article;

	@Column(name="taille")
	private double taille;

	@Column(name="prix_unitaire")
	private float prix_unitaire;

	@Column(name="quantite_stock")
	private int quantite_stock;
	
	@ManyToOne
	@JoinColumn(name="id_model")
	private Model model;

	/*
	 * Constructeurs
	 */
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(double taille, float prix_unitaire, int quantite_stock) {
		super();
		this.taille = taille;
		this.prix_unitaire = prix_unitaire;
		this.quantite_stock = quantite_stock;
	}

	/*
	 * GETTERS ET SETTERS
	 */

	public long getId_article() {
		return id_article;
	}

	public void setId_article(long id_article) {
		this.id_article = id_article;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public float getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public int getQuantite_stock() {
		return quantite_stock;
	}

	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}

	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Article(double taille, float prix_unitaire, int quantite_stock, Model model) {
		super();
		this.taille = taille;
		this.prix_unitaire = prix_unitaire;
		this.quantite_stock = quantite_stock;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", taille=" + taille + ", prix_unitaire=" + prix_unitaire
				+ ", quantite_stock=" + quantite_stock + ", model=" + model + "]";
	}

	

	/*
	 * ToString
	 */

}