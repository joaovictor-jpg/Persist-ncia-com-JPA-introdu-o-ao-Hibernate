package br.com.infoschool.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.infoschool.modelo.Curso;

public class CursoDao {

	private EntityManager entityManager;

	public CursoDao(EntityManager entityManger) {
		this.entityManager = entityManger;
	}

	public void cadastrarCursos(Curso cursos) {
		this.entityManager.persist(cursos);
	}
	
	//BUSCAR POR ID
	public Curso BuscarPorId(Long id) {
		return this.entityManager.find(Curso.class, id);
	}
	
	//BUSCAR POR TODOS OS CURSOS
	public List<Curso> buscaCursos() {
		String jpql = "SELECT c FROM Curso c";
		return this.entityManager.createQuery(jpql, Curso.class)
				.getResultList();
	}
	
	//LISTA CURSOS POR NOME
	public List<Curso> buscarPorNome(String nome) {
		String jpql = "SELECT c FROM Curso c WHERE c.nome = ?1";
		return this.entityManager.createQuery(jpql, Curso.class)
				.setParameter(1, nome)
				.getResultList();
	}
	
	//LISTA CURSOS POR CATEGORIA
	public List<Curso> buscarPorCategoria(String categoria) {
		String jpql = "SELECT c FROM Curso c WHERE c.categoria.nome = ?1";
		return this.entityManager.createQuery(jpql, Curso.class)
				.setParameter(1, categoria)
				.getResultList();
	}
	
	//RETORNA O PRECO DO CURSO
	public BigDecimal buscarPrecoDoCurso(String nome) {
		String jpql = "SELECT c.preco FROM Curso c WHERE c.nome = ?1";
		return this.entityManager.createQuery(jpql, BigDecimal.class)
				.setParameter(1, nome)
				.getSingleResult();
	}
 
}
