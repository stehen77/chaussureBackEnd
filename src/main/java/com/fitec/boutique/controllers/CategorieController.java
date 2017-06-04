package com.fitec.boutique.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fitec.boutique.entities.Categorie;

import com.fitec.boutique.service.IServiceCategorie;

@RestController
public class CategorieController {

	@Autowired
	private IServiceCategorie serviceCategorie;
	
	
	// selectionner tous les clients
	
		@RequestMapping(value = "/categories", method = RequestMethod.GET)
		public ResponseEntity<List<Categorie>> listAllCategories() {
			List<Categorie> categories = serviceCategorie.findAllCategories();
			if (categories.isEmpty()) {
				return new ResponseEntity<List<Categorie>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
		}
		
		/// * selectionner un Client par Id
		 
		@RequestMapping(value = "/categorie/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Categorie> getCategorie(@PathVariable("id") int id) {

			Categorie categorie = serviceCategorie.findById(id);
			if (categorie == null) {
				return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Categorie>(categorie, HttpStatus.OK);
		}
}
