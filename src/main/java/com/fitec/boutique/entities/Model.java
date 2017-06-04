package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  model.java
 * Author:  Fitec
 * Purpose: Defines the Class model
 ***********************************************************************/

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="model")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Model implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_model")
	private long id_model;

	@Column(name="nom_model")
	private String nom_model;

	@Column(name="description")
	private String description;

	@Column(name="couleur")
	private String couleur;
	
	@OneToMany(mappedBy = "model")
	private Collection<Article> articles;
	
	@OneToMany(mappedBy = "model")
	private Collection<Photo> photos;
	
	/*
	@ManyToMany(mappedBy="modeles")
	private Collection<Categorie> categories;*/

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(String nom_model, String description, String couleur) {
		super();
		this.nom_model = nom_model;
		this.description = description;
		this.couleur = couleur;
	}

	public long getId_model() {
		return id_model;
	}

	public void setId_model(long id_model) {
		this.id_model = id_model;
	}

	public String getNom_model() {
		return nom_model;
	}

	public void setNom_model(String nom_model) {
		this.nom_model = nom_model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Model [id_model=" + id_model + ", nom_model=" + nom_model + ", description=" + description
				+ ", couleur=" + couleur + "]";
	}

}