package br.com.casadocodigo.loja.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.DAO.AutorDAO;
import br.com.casadocodigo.loja.DAO.LivroDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {
	
	private Livro livro = new Livro();
	@Inject
	private LivroDAO livroDao;
	@Inject
	private AutorDAO autorDao;
	@Inject
	FacesContext context;
	
	private Part capaLivro;
	
	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@Transactional
	public String salvar() {
		livroDao.salvar(livro);
		
		FileSaver fileServer = new FileSaver();
		livro.setCapaPath(fileServer.write(capaLivro, "livros"));
		
		context.getExternalContext()
			.getFlash().setKeepMessages(true);
		
		context
			.addMessage(null, new FacesMessage("Livro adicionado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores(){
		return autorDao.getAutores();
	}


	public Part getCapaLivro() {
		return capaLivro;
	}

}
