package com.fitec.boutique.dao;

import java.util.List;


import com.fitec.boutique.entities.Article;

public interface IArticleDao {

	
	public Article findById(long id);

	public Article findByName(String name);

	public void saveArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticleById(long id);

	public List<Article> findAllArticles();
	
	boolean isArticleExist(Article article);
}
