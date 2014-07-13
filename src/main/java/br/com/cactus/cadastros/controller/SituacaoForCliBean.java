package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.repository.filter.SituacaoForCliFilter;
import br.com.cactus.cadastros.service.SituacaoForCliService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class SituacaoForCliBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private SituacaoForCli situacaoForCli;
	private SituacaoForCli situacaoForCliSelecionada;
	private SituacaoForCliFilter filtro;
	@Inject
	private SituacaoForCliService situacaoForCliService;
	
	@PostConstruct
	public void init(){
		limpar();
		this.filtro = new SituacaoForCliFilter();
	}
	
	public void limpar(){
		this.situacaoForCli = new SituacaoForCli();
		this.situacaoForCliSelecionada = null;
	}
	
	public void salvar(){
		this.situacaoForCli = situacaoForCliService.salvar(situacaoForCli);
		this.limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public void preparaAlterar(){
		this.setSituacaoForCli(situacaoForCliSelecionada);		
	}

	//GETTER AND SETTER
	public SituacaoForCli getSituacaoForCli() {
		return situacaoForCli;
	}

	public void setSituacaoForCli(SituacaoForCli situacaoForCli) {
		this.situacaoForCli = situacaoForCli;
	}

	public SituacaoForCli getSituacaoForCliSelecionada() {
		return situacaoForCliSelecionada;
	}

	public void setSituacaoForCliSelecionada(
			SituacaoForCli situacaoForCliSelecionada) {
		this.situacaoForCliSelecionada = situacaoForCliSelecionada;
	}

	public SituacaoForCliFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(SituacaoForCliFilter filtro) {
		this.filtro = filtro;
	}
}
