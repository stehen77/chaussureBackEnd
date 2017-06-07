package com.fitec.boutique.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very imp a verif
public class Role implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	private Integer id_role;
	
	@Column(name="nom_role")
	private String nom_role;

	@ManyToOne
	@JoinColumn(name="admin_id")
	//@JsonIgnore
	private Admin admin;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_role() {
		return id_role;
	}

	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}

	public String getNom_role() {
		return nom_role;
	}

	public void setNom_role(String nom_role) {
		this.nom_role = nom_role;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
	
	
	
}
