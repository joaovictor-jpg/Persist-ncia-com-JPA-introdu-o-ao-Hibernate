package br.com.infoschool.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("infoschool");
	
	public static EntityManager getEntityMananer() {
		return EMF.createEntityManager();
	}

}
