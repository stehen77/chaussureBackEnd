package com.fitec.boutique.dao;

import java.util.List;

import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Photo;

public interface IDAOPhoto {

	
	
	public Photo findById(long id);

	public Photo findByName(String name);

	public void savePhoto(Photo photo);

	public void updatePhoto(Photo photo);

	public void deletePhotoById(long id);

	public List<Photo> findAllPhotos();
	
	boolean isPhotoExist(Photo photo);
	
	public List<Photo> photosParModel(Long idPhot);
}
