package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.fitec.boutique.entities.Categorie;

public class CategorieDAOImpl implements IDAOCategorie {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Categorie findById(long id) {

		return em.find(Categorie.class, id);
	}

	@Override
	public Categorie findByName(String name) {

		Categorie categorie = new Categorie();
		String hql = "select c from Categorie c where nom_cat = ?";

		try {
			Query query = em.createQuery(hql);
			categorie = (Categorie) query.setParameter(0, name);

		} catch (Exception e) {

		}
		return categorie;
		
	}

	@Override
	public void saveCategorie(Categorie categorie) {
		if (categorie != null) {
			try {
				em.persist(categorie);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		if (categorie != null) {
			try {
				em.merge(categorie);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void deleteCategorieById(long id) {
		try {

			Categorie categorie = findById(id);
			em.remove(categorie);

		} catch (Exception e) {

		}

	}

	@Override
	public List<Categorie> findAllCategories() {
		Query req = em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public boolean isCategorieExist(Categorie categorie) {
		
		return findById(categorie.getId_categorie()) != null;
	}

}
