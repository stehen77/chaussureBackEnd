package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.fitec.boutique.entities.Photo;

public class PhotoDAOImpl implements IDAOPhoto {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Photo findById(long id) {

		return em.find(Photo.class, id);
	}

	@Override
	public Photo findByName(String name) {

		Photo photo = new Photo();
		String hql = "select p from Photo p where nam_photo = ?";

		try {
			Query query = em.createQuery(hql);
			photo = (Photo) query.setParameter(0, name);

		} catch (Exception e) {

		}
		return photo;
	}

	@Override
	public void savePhoto(Photo photo) {
		if (photo != null) {
			try {
				em.persist(photo);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void updatePhoto(Photo photo) {
		if (photo != null) {
			try {
				em.merge(photo);
			} catch (Exception e) {

			}
		}

	}

	@Override
	public void deletePhotoById(long id) {
		try {

			Photo photo = findById(id);
			em.remove(photo);

		} catch (Exception e) {

		}

	}

	@Override
	public List<Photo> findAllPhotos() {

		Query req = em.createQuery("select p from Photo p");
		return req.getResultList();
	}

	@Override
	public boolean isPhotoExist(Photo photo) {

		return findById(photo.getId_photo()) != null;
	}

	@Override
	public List<Photo> photosParModel(Long idPhot) {
		Query req = em.createQuery("select p from Photo p where p.model.id_model=:x ");
		req.setParameter("x", idPhot);
		return req.getResultList();
	}

}
