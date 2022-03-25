package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Autor;

public class AutorDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Autor> getAutores() {
		
		return manager.createQuery("SELECT a FROM Autor a", Autor.class)
				.getResultList();
	}
}
