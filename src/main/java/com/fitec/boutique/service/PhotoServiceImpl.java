package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fitec.boutique.dao.IDAOPhoto;
import com.fitec.boutique.entities.Photo;

@Transactional
public class PhotoServiceImpl implements IServicePhoto{

	private IDAOPhoto daoPhoto;
	
	
	@Override
	public Photo findById(long id) {
		// TODO Auto-generated method stub
		return daoPhoto.findById(id);
	}

	@Override
	public Photo findByName(String name) {
		// TODO Auto-generated method stub
		return daoPhoto.findByName(name);
	}

	@Override
	public void savePhoto(Photo photo) {
		daoPhoto.savePhoto(photo);
		
	}

	@Override
	public void updatePhoto(Photo photo) {
		daoPhoto.updatePhoto(photo);
		
	}

	@Override
	public void deletePhotoById(long id) {
		daoPhoto.deletePhotoById(id);
		
	}

	@Override
	public List<Photo> findAllPhotos() {
		
		return daoPhoto.findAllPhotos();
	}

	@Override
	public boolean isPhotoExist(Photo photo) {
		
		return daoPhoto.isPhotoExist(photo);
	}

	public IDAOPhoto getDaoPhoto() {
		return daoPhoto;
	}

	public void setDaoPhoto(IDAOPhoto daoPhoto) {
		this.daoPhoto = daoPhoto;
	}

	@Override
	public List<Photo> photosParModel(Long idPhot) {
		
		return daoPhoto.photosParModel(idPhot);
	}
	
	

}
