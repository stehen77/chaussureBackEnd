package com.fitec.boutique.dao;

import java.util.List;

import com.fitec.boutique.entities.Client;

public interface IDAOClient {

	
	public Client findById(long idAd);

	public Client findByName(String name);

	public void saveClient(Client client);

	public void updateClient(Client client);

	public void deleteClientById(long id);

	public List<Client> findAllClients();
	
	boolean isClientExist(Client client);
}
