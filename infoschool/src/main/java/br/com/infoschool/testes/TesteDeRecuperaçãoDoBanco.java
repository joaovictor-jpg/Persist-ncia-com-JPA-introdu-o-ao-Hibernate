package br.com.infoschool.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.infoschool.dao.CursoDao;
import br.com.infoschool.factory.ConnectionFactory;
import br.com.infoschool.modelo.Curso;

public class TesteDeRecuperaçãoDoBanco {

	public static void main(String[] args) {
		
		EntityManager entityManager = ConnectionFactory.getEntityMananer();
		CursoDao cursoDao = new CursoDao(entityManager);
		
		//BUSCAR POR ID
		Curso curso = cursoDao.BuscarPorId(1l);
		System.out.println("Buscar Por ID: " + curso.getNome());
		
		//LISTAR CURSOS
		List<Curso> cursos = cursoDao.buscaCursos();
		cursos.forEach(listaCursos -> System.out.println("Lista de cursos: " + listaCursos.getNome()));
		
		//LISTA CURSOS POR NOME
		cursos = cursoDao.buscarPorNome("Java Web");
		cursos.forEach(cursosPorNome -> System.out.println("Lista Por Nome: " + cursosPorNome.getNome()));
		
		//LISTA CURSOS POR CATEGORIA
		cursos = cursoDao.buscarPorCategoria("Interactive");
		cursos.forEach(listaPorCategoria -> System.out.println("Lista Por Categoria: " + listaPorCategoria.getNome()));
		
		//BUSCAR PREÇO DE UM CURSO POR NOME
		BigDecimal precoDoCurso = cursoDao.buscarPrecoDoCurso("Excel");
		System.out.println("Preço do curso de excel: R$" + precoDoCurso);
		
	}

}
