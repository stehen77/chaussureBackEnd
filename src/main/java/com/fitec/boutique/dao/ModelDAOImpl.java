package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fitec.boutique.entities.Model;

public class ModelDAOImpl implements IDAOModel {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Model findById(long id) {

		return em.find(Model.class, id);
	}

	@Override
	public Model findByName(String name) {

		Model model = new Model();
		String hql = "select m from Model m where nom_model = ?";

		try {
			Query query = em.createQuery(hql);
			model = (Model) query.setParameter(0, name);

		} catch (Exception e) {

		}
		return model;
	}

	@Override
	public void saveModel(Model model) {

		if (model != null) {
			try {
				em.persist(model);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void updateModel(Model model) {
		if (model != null) {
			try {
				em.merge(model);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void deleteModelById(long id) {
		try {

			Model model = findById(id);
			em.remove(model);

		} catch (Exception e) {

		}

	}

	@Override
	public List<Model> findAllModels() {
		Query req = em.createQuery("select m from Model m");
		return req.getResultList();
	}

	@Override
	public boolean isModelExist(Model model) {
		return findById(model.getId_model()) != null;
	}

}
