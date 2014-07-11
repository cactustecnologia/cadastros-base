package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.Endereco;
import br.com.cactus.cadastros.repository.EnderecoDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	
	@Inject
	private EnderecoDao dao;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.endereco = new Endereco();
	}
	
	@Transactional
	public void salvar(){
		if (endereco.getId() == null) {
			dao.salvar(endereco);
			FacesUtil.addInfoMessage("Endereço salvo com sucesso!");
		} else {
			dao.atualizar(endereco);
			FacesUtil.addInfoMessage("Endereço atualizado com sucesso!");
		}
		limpar();
	}

	
	//getter and setter
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
