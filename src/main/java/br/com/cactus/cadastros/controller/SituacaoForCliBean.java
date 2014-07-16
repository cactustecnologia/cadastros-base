package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;
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
	private LazyDataModel<SituacaoForCli> lazyModel;
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
	
	public void pesquisar(){
		lazyModel = situacaoForCliService.filtrados(filtro);
	}
	
	public void excluir(){
		situacaoForCliService.remover(situacaoForCliSelecionada);
		FacesUtil.addInfoMessage("Situação fornecedor cliente " + 
				situacaoForCliSelecionada.getNome() + " excluída com sucesso.");
	}
	
	public void handleClose(CloseEvent event) {
		if (situacaoForCli.getId() != null) {
			situacaoForCli = new SituacaoForCli();
			System.out.println("chamou fechar");
		}
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

	public LazyDataModel<SituacaoForCli> getLazyModel() {
		return lazyModel;
	}
}
