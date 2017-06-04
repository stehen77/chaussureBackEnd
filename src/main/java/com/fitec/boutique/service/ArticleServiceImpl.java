package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fitec.boutique.dao.IArticleDao;
import com.fitec.boutique.entities.Article;

@Transactional
public class ArticleServiceImpl implements IServiceArticle{
	
	private IArticleDao daoArticle;

	
	

	@Override
	public Article findById(long id) {
		
		return daoArticle.findById(id);
	}

	@Override
	public Article findByName(String name) {
		
		return daoArticle.findByName(name);
	}

	@Override
	public void saveArticle(Article article) {
		daoArticle.saveArticle(article);
		
	}

	@Override
	public void updateArticle(Article article) {
		daoArticle.updateArticle(article);
		
	}

	@Override
	public void deleteArticleById(long id) {
		daoArticle.deleteArticleById(id);
		
	}

	@Override
	public List<Article> findAllArticles() {
		
		return daoArticle.findAllArticles();
	}

	@Override
	public boolean isArticleExist(Article article) {
		
		return daoArticle.isArticleExist(article);
	}
	
	
	
	public IArticleDao getDaoArticle() {
		return daoArticle;
	}

	public void setDaoArticle(IArticleDao daoArticle) {
		this.daoArticle = daoArticle;
	}

}
