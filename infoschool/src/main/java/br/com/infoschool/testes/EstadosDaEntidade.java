package br.com.infoschool.testes;

import javax.persistence.EntityManager;

import br.com.infoschool.factory.ConnectionFactory;
import br.com.infoschool.modelo.Categoria;

public class EstadosDaEntidade {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("grupo oportunidade");
		
		EntityManager entityManager = ConnectionFactory.getEntityMananer();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria);
		categoria.setNome("Projeto");
		
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		categoria.setNome("grupo opotunidade");
		
	}

}
