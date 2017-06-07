package com.fitec.boutique.service;

import java.util.List;

import com.fitec.boutique.entities.Photo;

public interface IServicePhoto {

	
	public Photo findById(long id);

	public Photo findByName(String name);

	public void savePhoto(Photo photo);

	public void updatePhoto(Photo photo);

	public void deletePhotoById(long id);

	public List<Photo> findAllPhotos();
	
	boolean isPhotoExist(Photo photo);
	
	public List<Photo> photosParModel(Long idPhot);
}
