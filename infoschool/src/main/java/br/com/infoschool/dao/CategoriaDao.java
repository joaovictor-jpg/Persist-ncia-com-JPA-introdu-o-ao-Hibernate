package br.com.infoschool.dao;

import javax.persistence.EntityManager;

import br.com.infoschool.modelo.Categoria;

public class CategoriaDao {

	private EntityManager entityManager;

	public CategoriaDao(EntityManager entityManger) {
		this.entityManager = entityManger;
	}

	public void cadastrarCategoria(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
	
	public void update(Categoria categoria) {
		this.entityManager.merge(categoria);
	}
	
	public void remove(Categoria categoria) {
		//RETORNA PARA O ESTADO MANAGED
		categoria = entityManager.merge(categoria);
		this.entityManager.remove(categoria);
	}

}
