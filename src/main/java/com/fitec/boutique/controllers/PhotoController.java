package com.fitec.boutique.controllers;

import java.util.List;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fitec.boutique.entities.Photo;


import com.fitec.boutique.service.IServicePhoto;

@RestController
@CrossOriginResourceSharing(allowAllOrigins = true)
public class PhotoController {

	
	
	@Autowired
	private IServicePhoto servicePhoto;

	
	@RequestMapping(value = "/photo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Photo> getPhoto(@PathVariable("id") int id) {

		Photo photo = servicePhoto.findById(id);
		if (photo == null) {
			return new ResponseEntity<Photo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Photo>(photo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public ResponseEntity<List<Photo>> listAllPhotos() {
		List<Photo> photos = servicePhoto.findAllPhotos();
		if (photos.isEmpty()) {
			return new ResponseEntity<List<Photo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
	}
	
	
	

	public IServicePhoto getServicePhoto() {
		return servicePhoto;
	}


	public void setServicePhoto(IServicePhoto servicePhoto) {
		this.servicePhoto = servicePhoto;
	}
	
	
}
