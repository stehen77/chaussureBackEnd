package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.fitec.boutique.entities.Admin;

public class AdminDAOImpl implements IDaoAdmin{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Admin findById(long idAd) {
		
		return em.find(Admin.class, idAd);
	}

	
	@Override
	public Admin findByName(String name) {
		
		Admin admin = new Admin();
		String hql = "select a from Admin a where name = ?";
		
		try {
			Query query = em.createQuery(hql);
			admin = (Admin) query.setParameter(0, name);
			
			
		} catch (Exception e) {
			
		}
		return admin;
	}

	@Override
	public void saveAdmin(Admin admin) {
		if (admin != null) {
			try {
				em.persist(admin);
			} catch (Exception e) {
				
			}
		}
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		
		if (admin != null) {
			try {
				em.merge(admin);
			} catch (Exception e) {
				
			}
		}
		
	}

	@Override
	public void deleteAdminById(long id) {
		
		try {
			
			Admin admin = findById(id);
			em.remove(admin);
			
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public List<Admin> findAllAdmins() {
		
		Query req = em.createQuery("select a from Admin a");
		return req.getResultList();
	}


	@Override
	public boolean isAdminExist(Admin admin) {
		
		return findByName(admin.getNom_admin())!=null;
	}

}
