package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivis;

@Named
@ViewScoped
public class EstadoCivilController implements Serializable {

	private static final long serialVersionUID = 1L;

	private EstadoCivil estadoCivil;
	@Inject
	private EstadoCivis estadocivis;
	
	public void salvar(EstadoCivil estadoCivil){
		this.estadoCivil = this.estadocivis.salvar(estadoCivil);
	}
	
	
}