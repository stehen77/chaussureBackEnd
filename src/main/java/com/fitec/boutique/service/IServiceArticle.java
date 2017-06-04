package com.fitec.boutique.service;

import java.util.List;

import com.fitec.boutique.entities.Article;

public interface IServiceArticle {

	public Article findById(long id);

	public Article findByName(String name);

	public void saveArticle(Article article);

	public void updateArticle(Article article);

	public void deleteArticleById(long id);

	public List<Article> findAllArticles();

	boolean isArticleExist(Article article);

	public List<Article> articlesParMotCle(String mc);

	public List<Article> articlesParModel(Long idMod);

}
