package com.fitec.boutique.entities;

/***********************************************************************
 * Module:  Categorie.java
 * Author:  Fitec
 * Purpose: Defines the Class Categorie
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="categorie")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie")
	private long id_categorie;

	@Column(name="nom_cat")
	private String nom_cat;
	
	

	@ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	//@JsonIgnore
	private Collection<Model> models;
	
	
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nom_cat) {
		super();
		this.nom_cat = nom_cat;
	}

	public Categorie(String nom_cat, Collection<Model> models) {
		super();
		this.nom_cat = nom_cat;
		this.models = models;
	}
	
	public long getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(long id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getNom_cat() {
		return nom_cat;
	}

	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}

	@Override
	public String toString() {
		return "Categorie [id_categorie=" + id_categorie + ", nom_cat=" + nom_cat + "]";
	}

	public Collection<Model> getModels() {
		return models;
	}

	public void setModels(Collection<Model> models) {
		this.models = models;
	}

	

	
}