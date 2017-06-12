package com.fitec.boutique.controllers;

import java.util.List;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Categorie;
import com.fitec.boutique.entities.Commande;
import com.fitec.boutique.service.IServiceCommande;

@RestController
@CrossOriginResourceSharing(allowAllOrigins = true)
public class CommandeController {

	@Autowired
	private IServiceCommande serviceCommande;
	
	

	// selectionner tous les clients

	@RequestMapping(value = "/commandes", method = RequestMethod.GET)
	public ResponseEntity<List<Commande>> listAllCommandes() {
		List<Commande> commandes = serviceCommande.findAllCommandes();
		if (commandes.isEmpty()) {
			return new ResponseEntity<List<Commande>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Commande>>(commandes, HttpStatus.OK);
	}
	
	// selectionner une commande
	
	@RequestMapping(value = "/commande/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Commande> getCommande(@PathVariable("id") int id) {

		Commande commande = serviceCommande.findById(id);
		if (commande == null) {
			return new ResponseEntity<Commande>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Commande>(commande, HttpStatus.OK);
	}
	
	
	// Ajout d'une commande et des lignes de commandes associées
	////////////////////////////////////////////////////////////
	@RequestMapping(value = "/commande/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addCommande(@RequestBody Commande commande, UriComponentsBuilder ucb) {
		if (serviceCommande.isCommandeExist(commande)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			serviceCommande.saveCommande(commande);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/admin/{id}").buildAndExpand(commande.getId_commande()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	
	
}
