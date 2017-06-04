package com.fitec.boutique.service;

import java.util.List;

import com.fitec.boutique.entities.Client;

public interface IServiceClient {

	
	public Client findById(long id);

	public Client findByName(String name);

	public void saveClient(Client client);

	public void updateClient(Client client);

	public void deleteClientById(long id);

	public List<Client> findAllClients();
	
	boolean isClientExist(Client client);
}
