/*package com.fitec.boutique.controllers;

import java.util.List;

import javax.transaction.Transactional;

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


import com.fitec.boutique.entities.Article;

import com.fitec.boutique.service.IServiceArticle;

@RestController
public class ArticleController {

	@Autowired
	private IServiceArticle serviceArticle;
	
	

	
	 // selectionner un Article par Id
	 
	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Article> getArticle(@PathVariable("id") int id) {

		Article article = serviceArticle.findById(id);
		if (article == null) {
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}

	
	 // Selectionner tous les Articles
	 
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ResponseEntity<List<Article>> listAllArticles() {
		List<Article> articles = serviceArticle.findAllArticles();
		if (articles.isEmpty()) {
			return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
	}

	public IServiceArticle getServiceArticle() {
		return serviceArticle;
	}

	public void setServiceArticle(IServiceArticle serviceArticle) {
		this.serviceArticle = serviceArticle;
	}

	
	

	////////////////////// GETERS ET SETTERS ///////////////////////////////

	

}
*/