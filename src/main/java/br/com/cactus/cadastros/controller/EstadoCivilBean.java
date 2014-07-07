package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivilDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EstadoCivilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	private EstadoCivil estadoCivil;
	
	@Inject
	private EstadoCivilDao dao;
	
	public void limpar(){
		this.estadoCivil = new EstadoCivil();
	}
	
	@Transactional
	public void salvar(){
		if(estadoCivil.getId() == null){
			dao.salvar(estadoCivil);
			FacesUtil.addInfoMessage("Estado Civil salvo com sucesso!");
		} else{
			dao.atualizar(estadoCivil);
			FacesUtil.addInfoMessage("Estado Civil atualizado com sucesso!");
		}
		limpar();
	}
	
	
	
	//getter and setter
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}