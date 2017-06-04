package com.fitec.boutique.dao;

import java.util.List;


import com.fitec.boutique.entities.Admin;



public interface IDaoAdmin {

	
	
	public Admin findById(long idAd);

	public Admin findByName(String name);

	public void saveAdmin(Admin admin);

	public void updateAdmin(Admin admin);

	public void deleteAdminById(long id);

	public List<Admin> findAllAdmins();
	
	boolean isAdminExist(Admin admin);
}
