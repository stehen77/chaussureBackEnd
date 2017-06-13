package com.fitec.boutique.service;

import java.util.List;
import javax.transaction.Transactional;

import com.fitec.boutique.dao.IDAOClient;
import com.fitec.boutique.entities.Client;

@Transactional
public class ClientServiceImpl implements IServiceClient{

	private IDAOClient daoClient;
	
	
	
	public IDAOClient getDaoClient() {
		return daoClient;
	}

	public void setDaoClient(IDAOClient daoClient) {
		this.daoClient = daoClient;
	}

	
	@Override
	public Client findById(long id) {
		
		return daoClient.findById(id);
	}

	@Override
	public Client findByName(String name) {
		
		return daoClient.findByName(name);
	}

	@Override
	public Client saveClient(Client client) {
		return daoClient.saveClient(client);
		
	}

	@Override
	public void updateClient(Client client) {
		daoClient.updateClient(client);
		
	}

	@Override
	public void deleteClientById(long id) {
		daoClient.deleteClientById(id);
		
	}

	@Override
	public List<Client> findAllClients() {
		
		return daoClient.findAllClients();
	}

	@Override
	public boolean isClientExist(Client client) {
		
		return daoClient.isClientExist(client);
	}

}
