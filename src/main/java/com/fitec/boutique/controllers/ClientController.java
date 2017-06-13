package com.fitec.boutique.controllers;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.service.IServiceClient;

@RestController
@CrossOrigin(origins = {"*"})
public class ClientController {

	
	@Autowired
	private IServiceClient serviceClient;
	

	 //* Ajouter un Client
	 
	/*@RequestMapping(value = "/client/new", method = RequestMethod.POST)
	public ResponseEntity<Void> addClient(@RequestBody Client client, UriComponentsBuilder ucb) {
		if (serviceClient.isClientExist(client)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			serviceClient.saveClient(client);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/client/{id}").buildAndExpand(client.getId_client()).toUri());
			
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
*/
	@RequestMapping(value="/client/new",method=RequestMethod.POST)
	public Client saveClients(@RequestBody Client client){
		
		 serviceClient.saveClient(client);
		 return client;
	}
	
	/// * selectionner un Client par Id
	 
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {

		Client client = serviceClient.findById(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// selectionner tous les clients
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAllClients() {
		List<Client> clients = serviceClient.findAllClients();
		if (clients.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}
	
	
		@RequestMapping(value="client/{id}",method=RequestMethod.PUT)
		public void updateClients(@PathVariable(value="id")long id,@RequestBody Client client){
			client.setId_client(id);	
			 serviceClient.updateClient(client);
		}
		
		// * supprimer un administrateur par son id

		@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Client> deleteClient(@PathVariable("id") int id) {

			Client client = serviceClient.findById(id);
			if (client == null) {
				return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
			}

			serviceClient.deleteClientById(id);
			return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
		}
		
	
		
		@RequestMapping(value = "/clients/login/{email}/{mdp}", method = RequestMethod.GET)
		public ResponseEntity<List<Client>> authenticateUser(@PathVariable("email") String email,
				                @PathVariable("mdp") String mdp
				                                     ) {
			
			List<Client> clients = serviceClient.findAllClients();
			if (clients.isEmpty()) {
				return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
		}
		
		
		
		@POST
		@Path("/client/add")
		
		public Response insererClient(Client client){
			try {
				client = serviceClient.saveClient(client);
				return  Response
						.status(Status.OK)
						.entity(client)
						.build();
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				return  Response.status(Status.CONFLICT).build();
			}
		}
		
}
