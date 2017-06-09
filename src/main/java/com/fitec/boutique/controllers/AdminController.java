package com.fitec.boutique.controllers;

import java.util.List;

import javax.transaction.Transactional;

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
import com.fitec.boutique.service.IServiceAdmin;

@RestController
@CrossOriginResourceSharing(allowAllOrigins = true)
public class AdminController {

	@Autowired
	private IServiceAdmin service;
	
	
	 //* Ajouter un Administrateur
	 
	@RequestMapping(value = "/admin/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addAdmin(@RequestBody Admin admin, UriComponentsBuilder ucb) {
		if (service.isAdminExist(admin)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			service.saveAdmin(admin);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/admin/{id}").buildAndExpand(admin.getId_admin()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	
	/// * selectionner un Admin par Id
	 
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") int id) {

		Admin admin = service.findById(id);
		if (admin == null) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	
	// * Selectionner tous les Admin
	 
	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ResponseEntity<List<Admin>> listAllAdmins() {
		List<Admin> admins = service.findAllAdmins();
		if (admins.isEmpty()) {
			return new ResponseEntity<List<Admin>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
	}

	
	// * Mettre à jour un administrateur
	 
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody Admin adm) {

		Admin admin = service.findById(id);

		if (admin == null) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}

		adm.setNom_admin(adm.getNom_admin());
		adm.setPrenom_admin(adm.getPrenom_admin());
		adm.setEmail_admin(adm.getEmail_admin());

		service.updateAdmin(admin);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	
	// * supprimer un administrateur par son id
	 
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") long id) {

		Admin admin = service.findById(id);
		if (admin == null) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}

		service.deleteAdminById(id);
		return new ResponseEntity<Admin>(HttpStatus.NO_CONTENT);
	}

	////////////////////// GETERS ET SETTERS ///////////////////////////////

	public IServiceAdmin getService() {
		return service;
	}

	public void setService(IServiceAdmin service) {
		this.service = service;
	}

}
