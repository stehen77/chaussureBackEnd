package com.fitec.boutique.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fitec.boutique.dao.IDaoAdmin;
import com.fitec.boutique.entities.Admin;

@Transactional
public class AdminServiceImpl implements IServiceAdmin {

	private IDaoAdmin dao;

	@Override
	public Admin findById(long idAd) {

		return dao.findById(idAd);
	}

	@Override
	public Admin findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public void saveAdmin(Admin admin) {
		dao.saveAdmin(admin);

	}

	@Override
	public void updateAdmin(Admin admin) {
		dao.updateAdmin(admin);

	}

	@Override
	public void deleteAdminById(long id) {
		dao.deleteAdminById(id);

	}

	@Override
	public List<Admin> findAllAdmins() {
		
		return dao.findAllAdmins();
	}

	public IDaoAdmin getDao() {
		return dao;
	}

	public void setDao(IDaoAdmin dao) {
		this.dao = dao;
	}

	@Override
	public boolean isAdminExist(Admin admin) {
		
		return dao.isAdminExist(admin);
	}

}
