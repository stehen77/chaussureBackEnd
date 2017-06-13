package com.fitec.boutique.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.entities.Photo;
import com.fitec.boutique.service.IServiceArticle;
import com.fitec.boutique.service.IServiceModel;
import com.fitec.boutique.service.IServicePhoto;

@RestController
@CrossOrigin(origins = {"*"})
public class ModelController {

	@Autowired
	private IServiceModel serviceModel;
	
	@Autowired
	private IServiceArticle serviceArticle;

	
	@Autowired
	private IServicePhoto servicePhoto;
	
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
	
	@RequestMapping(value = "/model/{id}/articles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> getListeArticlesFonctionModel(@PathVariable("id") long id) {

		List<Article> articles = serviceArticle.articlesParModel(id);
		if (articles.isEmpty()) {
			return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/model/{id}/photos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Photo>> getListePhotosFonctionModel(@PathVariable("id") long id) {

		List<Photo> photos = servicePhoto.photosParModel(id);
		if (photos.isEmpty()) {
			return new ResponseEntity<List<Photo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Photo>>(photos, HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody // le resulata dans le corps de la reponse
	public byte[] photoProd(Long idProd) throws IOException {

		Produit p = metier.getProduit(idProd);
		File f = new File(System.getProperty("java.io.tmpdir") + "/PROD_" + idProd + "_" + p.getPhoto());
		//
		return IOUtils.toByteArray(new FileInputStream(f));

	}*/
	
	
	public IServiceModel getServiceModel() {
		return serviceModel;
	}

	public void setServiceModel(IServiceModel serviceModel) {
		this.serviceModel = serviceModel;
	}


	public IServiceArticle getServiceArticle() {
		return serviceArticle;
	}


	public void setServiceArticle(IServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}


	public IServicePhoto getServicePhoto() {
		return servicePhoto;
	}


	public void setServicePhoto(IServicePhoto servicePhoto) {
		this.servicePhoto = servicePhoto;
	}
	
	
	
}
