package com.fitec.boutique.entities;
/***********************************************************************
 * Module:  photo.java
 * Author:  Fitec
 * Purpose: Defines the Class photo
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
@Table(name="photo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Photo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_photo")
	private long id_photo;

	@Column(name="nom_photo")
	private String nom_photo;

	@Column(name="url")
	private String url;
	
	@ManyToOne
	@JoinColumn(name="id_model")
	private Model model;

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Photo(String nom_photo, String url) {
		super();
		this.nom_photo = nom_photo;
		this.url = url;
	}

	public long getId_photo() {
		return id_photo;
	}

	public void setId_photo(long id_photo) {
		this.id_photo = id_photo;
	}

	public String getNom_photo() {
		return nom_photo;
	}

	public void setNom_photo(String nom_photo) {
		this.nom_photo = nom_photo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Photo [id_photo=" + id_photo + ", nom_photo=" + nom_photo + ", url=" + url + "]";
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	
}