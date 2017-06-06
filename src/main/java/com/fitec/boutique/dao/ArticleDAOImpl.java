package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Article;

public class ArticleDAOImpl implements IArticleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Article findById(long id) {

		return em.find(Article.class, id);
	}

	@Override
	public Article findByName(String name) {

		/*
		 * Article article = new Article(); String hql =
		 * "select a from Article a where name = ?";
		 * 
		 * try { Query query = em.createQuery(hql); article = (Article)
		 * query.setParameter(0, name);
		 * 
		 * } catch (Exception e) {
		 * 
		 * } return article;
		 */
		return null;
	}

	@Override
	public void saveArticle(Article article) {
		if (article != null) {
			try {
				em.persist(article);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void updateArticle(Article article) {
		if (article != null) {
			try {
				em.merge(article);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void deleteArticleById(long id) {
		try {

			Article article = findById(id);
			em.remove(article);

		} catch (Exception e) {

		}

	}

	@Override
	public List<Article> findAllArticles() {
		Query req = em.createQuery("select a from Article a");
		return req.getResultList();
	}

	@Override
	public boolean isArticleExist(Article article) {

		return findById(article.getId_article()) != null;
	}

	

	@Override
	public List<Article> articlesParModel(Long idMod) {
		Query req = em.createQuery("select a from Article a where a.model.id_model=:x ");
		req.setParameter("x", idMod);
		return req.getResultList();
	}

	@Override
	public List<Article> articlesParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

}
