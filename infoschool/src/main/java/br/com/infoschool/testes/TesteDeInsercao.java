package br.com.infoschool.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.infoschool.dao.CategoriaDao;
import br.com.infoschool.dao.CursoDao;
import br.com.infoschool.factory.ConnectionFactory;
import br.com.infoschool.modelo.Categoria;
import br.com.infoschool.modelo.Curso;

public class TesteDeInsercao {

	public static void main(String[] args) {
		
		Categoria categoria = new Categoria("Interactive");
		Curso curso = new Curso("Excel", "Planilha eletrônica", new BigDecimal("400"), categoria);
		Categoria categoria2 = new Categoria("OneByte");
		Curso curso2 = new Curso("Java Web", "Programação", new BigDecimal("550"), categoria2);
		
		EntityManager entityManager = ConnectionFactory.getEntityMananer();
		CursoDao cursoDao = new CursoDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		
		entityManager.getTransaction().begin();
		categoriaDao.cadastrarCategoria(categoria);
		categoriaDao.cadastrarCategoria(categoria2);
		cursoDao.cadastrarCursos(curso);
		cursoDao.cadastrarCursos(curso2);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
