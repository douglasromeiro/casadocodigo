package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.DAO.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class AdminListaLivrosBean {

	private List<Livro> livros = new ArrayList<>();
	
	@Inject
	private LivroDAO dao;
	
	public List<Livro> getLivros() {
		
		this.livros = dao.listar();
		return livros;
	}
	
}
