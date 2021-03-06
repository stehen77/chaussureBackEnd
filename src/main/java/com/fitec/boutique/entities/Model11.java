package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  model.java
 * Author:  Fitec
 * Purpose: Defines the Class model
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="model")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Model11 implements Serializable{

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
	@JsonIgnore
	private Collection<Article> articles;
	
	@OneToMany(mappedBy = "model")
	@JsonIgnore
	private Collection<Photo> photos;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "model_categorie", joinColumns = @JoinColumn(name = "id_model"), inverseJoinColumns = @JoinColumn(name = "id_categorie"))
	@JsonIgnore
	private Collection<Categorie> categories;
	
	
	
	public Model11() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model11(String nom_model, String description, String couleur) {
		super();
		this.nom_model = nom_model;
		this.description = description;
		this.couleur = couleur;
	}
	
	public Model11(String nom_model, String description, String couleur, Collection<Categorie> categories) {
		super();
		this.nom_model = nom_model;
		this.description = description;
		this.couleur = couleur;
		this.categories = categories;
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
				+ ", couleur=" + couleur + ", articles=" + articles + ", photos=" + photos + ", categories="
				+ categories + "]";
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public Collection<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}

	

	

	

	
	
}