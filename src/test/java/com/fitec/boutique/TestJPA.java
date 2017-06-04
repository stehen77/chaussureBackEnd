package com.fitec.boutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fitec.boutique.entities.Admin;
import com.fitec.boutique.entities.Article;
import com.fitec.boutique.entities.Client;
import com.fitec.boutique.entities.Model;
import com.fitec.boutique.service.IServiceAdmin;

import com.fitec.boutique.service.IServiceClient;

public class TestJPA {

	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

	}

	/*
	 * @Test public void test1() {
	 * 
	 * try {
	 * 
	 * 
	 * 
	 * IServiceAdmin service = (IServiceAdmin) context.getBean("service");
	 * 
	 * List<Admin> admin1 = service.findAllAdmins(); service.saveAdmin(new
	 * Admin("nom_admin", "prenom_admin", "admin@admin0fr"));
	 * service.saveAdmin(new Admin("nom_admin1", "prenom_admin1",
	 * "admin1@admin.fr")); service.saveAdmin(new Admin("nom_admin2",
	 * "prenom_admin2", "admin2@admin.fr"));
	 * 
	 * 
	 * 
	 * List<Admin> admin2 = service.findAllAdmins();
	 * assertTrue(admin1.size()+2==admin2.size()); } catch (Exception e) {
	 * assertTrue(e.getMessage(),false); } }
	 */

	/*@Test
	public void test1() {

		try {

			IServiceArticle service = (IServiceArticle) context.getBean("service");

			List<Article> article1 = service.findAllArticles();
			service.saveArticle(new Article(2.5, 52, 10, (new Model("aaa", "hhhhhhhh", "yh"))));
			
			

			List<Article> article2 = service.findAllArticles();
			assertTrue(article1.size() + 2 == article2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
	
	@Test
	public void test1() {

		try {

			IServiceClient serviceClient = (IServiceClient) context.getBean("serviceClient");

			List<Client> client1 = serviceClient.findAllClients();
			serviceClient.saveClient(new Client("aa", "bbb", "ee", "yyy", "yyy"));
			
			

			List<Client> client2 = serviceClient.findAllClients();
			assertTrue(client1.size() + 2 == client2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
