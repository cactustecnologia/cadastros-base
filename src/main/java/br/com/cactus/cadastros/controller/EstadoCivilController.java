package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivis;

@Named
@ViewScoped
public class EstadoCivilController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	private EstadoCivil estadoCivil;
	@Inject
	private EstadoCivis estadocivis;
	
	public void limpar(){
		this.estadoCivil = new EstadoCivil();
	}
	
	public void salvar(){
		this.estadoCivil = this.estadocivis.salvar(estadoCivil);
	}
	
	public void atualizar(){
		
	}

	
	
	//getter and setter
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public EstadoCivis getEstadocivis() {
		return estadocivis;
	}

	public void setEstadocivis(EstadoCivis estadocivis) {
		this.estadocivis = estadocivis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}