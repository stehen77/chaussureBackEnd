package com.fitec.boutique.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="admin")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_admin")
	private long id_admin;
	
	@Column(name="nom_admin")
	private String nom_admin;
    
	@Column(name="prenom_admin")
	private String prenom_admin;

	@Column(name="email_admin")
	private String email_admin;

	/*
	 * Constructeurs
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom_admin, String prenom_admin, String email_admin) {
		super();
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
		this.email_admin = email_admin;
	}

	/*
	 * GETTERS AND SETTERS
	 */

	public long getId_admin() {
		return id_admin;
	}

	public void setId_admin(long id_admin) {
		this.id_admin = id_admin;
	}

	public String getNom_admin() {
		return nom_admin;
	}

	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}

	public String getPrenom_admin() {
		return prenom_admin;
	}

	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", nom_admin=" + nom_admin + ", prenom_admin=" + prenom_admin
				+ ", email_admin=" + email_admin + "]";
	}

}