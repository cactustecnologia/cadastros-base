package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.filter.EstadoCivilFilter;
import br.com.cactus.cadastros.service.EstadoCivilService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class EstadoCivilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EstadoCivil estadoCivil;
	private EstadoCivil estadoCivilSelecionado;
	private LazyDataModel<EstadoCivil> lazyModel;
	private EstadoCivilFilter filtro;
	@Inject
	private EstadoCivilService civilService;	
	
	@PostConstruct
	public void init(){
		limpar();
		filtro = new EstadoCivilFilter();
		pesquisar();
	}
	
	public void limpar(){		
		this.estadoCivil = new EstadoCivil();
		this.estadoCivilSelecionado = null;
	}
		
	public void salvar(){
		civilService.salvar(estadoCivil);
		limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public void pesquisar(){
		lazyModel = civilService.filtrados(filtro);
		limparPesquisa();
	}
	
	public void limparPesquisa(){
		this.filtro = new EstadoCivilFilter();
	}
	
	public void excluir() {
		civilService.remover(estadoCivilSelecionado);
		pesquisar();
		FacesUtil.addInfoMessage("Estado civil " + estadoCivilSelecionado.getNome()
				+ " excluído com sucesso.");
	}
	
	public void preparaAlterar() {
		this.setEstadoCivil(estadoCivilSelecionado);
	}
	
	public void handleClose(CloseEvent event) {
		if (estadoCivil.getId() != null) {
			estadoCivil = new EstadoCivil();			
		}
	}
	
	//getter and setter
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public EstadoCivil getEstadoCivilSelecionado() {
		return estadoCivilSelecionado;
	}

	public void setEstadoCivilSelecionado(EstadoCivil estadoCivilSelecionado) {
		this.estadoCivilSelecionado = estadoCivilSelecionado;
	}

	public LazyDataModel<EstadoCivil> getLazyModel() {
		return lazyModel;
	}

	public EstadoCivilFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(EstadoCivilFilter filtro) {
		this.filtro = filtro;
	}	
}