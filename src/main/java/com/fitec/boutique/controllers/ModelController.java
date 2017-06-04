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

import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.service.IServiceModel;

@RestController
public class ModelController {

	@Autowired
	private IServiceModel serviceModel;

	
	@RequestMapping(value = "/model/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Model> getModel(@PathVariable("id") int id) {

		Model model = serviceModel.findById(id);
		if (model == null) {
			return new ResponseEntity<Model>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Model>(model, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/models", method = RequestMethod.GET)
	public ResponseEntity<List<Model>> listAllModels() {
		List<Model> models = serviceModel.findAllModels();
		if (models.isEmpty()) {
			return new ResponseEntity<List<Model>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Model>>(models, HttpStatus.OK);
	}
	
	
	
	
	
	
	public IServiceModel getServiceModel() {
		return serviceModel;
	}

	public void setServiceModel(IServiceModel serviceModel) {
		this.serviceModel = serviceModel;
	}
	
	
}
