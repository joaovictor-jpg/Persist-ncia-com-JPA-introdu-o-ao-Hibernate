package br.com.infoschool.testes;

import javax.persistence.EntityManager;

import br.com.infoschool.factory.ConnectionFactory;
import br.com.infoschool.modelo.Categoria;

public class TesteRemoveDoEstadoManaged {

	public static void main(String[] args) {

		Categoria categoria = new Categoria("grupo oportunidade");

		EntityManager entityManager = ConnectionFactory.getEntityMananer();

		entityManager.getTransaction().begin();

		// ÍNICIO ESTADO MANEGED
		entityManager.persist(categoria);
		categoria.setNome("Projeto");

		entityManager.flush();
		entityManager.clear();
		// FIM ESTADO MANAGED

		// RETORNANDO PARA O ESTADO MANEGED
		categoria = entityManager.merge(categoria);
		categoria.setNome("Melhor Idade");
		entityManager.flush();
		entityManager.remove(categoria);
		entityManager.flush();

		
	}

}
