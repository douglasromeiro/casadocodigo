package br.com.casadocodigo.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.DAO.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class LivroDetalheBean {

	@Inject
	private LivroDAO dao;
	private Livro livro;
	private Long id;
	
	public void carregarDetalhe() {
		this.livro = dao.buscarPorId(id);
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
