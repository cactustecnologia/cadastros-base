package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.Contato;
import br.com.cactus.cadastros.repository.ContatoDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Contato contato;
	
	@Inject
	private ContatoDao dao;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.contato = new Contato();
	}

	@Transactional
	public void salvar(){
		if (contato.getId() == null) {
			dao.salvar(contato);
			FacesUtil.addInfoMessage("Contato salvo com sucesso!");
		} else {
			dao.atualizar(contato);
			FacesUtil.addInfoMessage("Contato atualizado com sucesso!");
		}
		limpar();
	}

	
	//getter and setter
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
