package com.fitec.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Client;

public class ClientDAOImpl implements IDAOClient{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Client findById(long id) {
		
		return em.find(Client.class, id);
	}

	@Override
	public Client findByName(String nom) {
		
		Client client = new Client();
		String hql = "select c from Client c where nom = ?";
		
		try {
			Query query = em.createQuery(hql);
			client = (Client) query.setParameter(0, nom);
			
			
		} catch (Exception e) {
			
		}
		return client;
	}

	@Override
	public void saveClient(Client client) {
		em.persist(client);
		
	}

	@Override
	public void updateClient(Client client) {
		em.merge(client);
		
	}

	@Override
	public void deleteClientById(long id) {
		em.remove(id);
		
	}

	@Override
	public List<Client> findAllClients() {
		
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

	@Override
	public boolean isClientExist(Client client) {
		
		return findByName(client.getNom())!=null;
	}

}
