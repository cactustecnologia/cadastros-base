package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivis;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EstadoCivilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EstadoCivil estadoCivil;
	
	@Inject
	private EstadoCivis estadoCivis;
		
	public EstadoCivilBean(){
		limpar();
	}
	
	@Transactional	
	public void salvar(){		
		this.estadoCivil = estadoCivis.salvar(estadoCivil);
		limpar();
		FacesUtil.addInfoMessage("Estado Civil salvo com sucesso!");
	}
	
	public void limpar(){
		estadoCivil = new EstadoCivil();
	}	
	
	//getter and setter
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}