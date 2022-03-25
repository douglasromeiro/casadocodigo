package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.casadocodigo.loja.models.Livro;

@Stateful
public class LivroDAO {

	//Solução para lazyException
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> listar(){

		String sql = "select distinct(l) from Livro l "
				+ " join fetch l.autores";
		
		return manager.createQuery(sql, Livro.class).getResultList();
	}

	public List<Livro> ultimosLancamento() {
		
		String jpql = "select l from Livro l order by l.id desc";
		return manager.createQuery(jpql, Livro.class)
		.setMaxResults(5)
		.getResultList();
	}

	public List<Livro> demaisLivros() {
		
		String jpql = "select l from Livro l order by l.id desc";
		return manager.createQuery(jpql, Livro.class)
				.setFirstResult(5)
				.getResultList();
	}

	public Livro buscarPorId(Long id) {
		
		//Com o type exntended podemos usar o find do manager pra buscar os dados no bancos em risco de erro no Lazily
		return manager.find(Livro.class, id);
		
		//Usar a query planejada, query planned queries pode ser mais performatico
//		String jpql = "select l from Livro l join fetch l.autores "
//				+ " where l.id = :id";
//		return manager.createQuery(jpql, Livro.class)
//				.setParameter("id", id)
//				.getSingleResult();
	}
}
