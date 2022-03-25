package br.com.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.DAO.LivroDAO;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class HomeBean {

	@Inject
	private LivroDAO dao;
	
	public List<Livro> ultimosLancamento(){
		return dao.ultimosLancamento();
		
	}
	
	public List<Livro> demaisLivros(){
		return dao.demaisLivros();
	}
}
