package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.repository.filter.AtividadeForCliFilter;
import br.com.cactus.cadastros.service.AtividadeForCliService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AtividadeForCliBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private AtividadeForCli atividadeForCli;
	private AtividadeForCliFilter filtro;
	private AtividadeForCli atividadeForCliSelecionada;
	@Inject
	private AtividadeForCliService atividadeForCliService;
	private LazyDataModel<AtividadeForCli> lazyModel;
	
	@PostConstruct
	public void init(){
		limpar();
		filtro = new AtividadeForCliFilter();
		pesquisar();
	}
	
	public void limpar(){
		this.atividadeForCli = new AtividadeForCli();
		this.atividadeForCliSelecionada = null;
	}
	
	public void salvar(){
		atividadeForCli = atividadeForCliService.salvar(atividadeForCli);
		limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public void preparaAlterar(){
		this.setAtividadeForCli(atividadeForCliSelecionada);
	}
	
	public void excluir(){
		atividadeForCliService.remover(atividadeForCliSelecionada);
		FacesUtil.addInfoMessage("Atividade fornecedor cliente " + 
				atividadeForCliSelecionada.getNome() + " excluída com sucesso.");
	}
	
	public void pesquisar(){
		this.lazyModel = atividadeForCliService.filtrados(filtro);
	}
	
	public void handleClose(CloseEvent event) {
		if (atividadeForCli.getId() != null) {
			atividadeForCli = new AtividadeForCli();
			System.out.println("chamou fechar");
		}
	}

	//GETTER AND SETTER
	public AtividadeForCli getAtividadeForCli() {
		return atividadeForCli;
	}

	public void setAtividadeForCli(AtividadeForCli atividadeForCli) {
		this.atividadeForCli = atividadeForCli;
	}

	public AtividadeForCliFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(AtividadeForCliFilter filtro) {
		this.filtro = filtro;
	}

	public AtividadeForCli getAtividadeForCliSelecionada() {
		return atividadeForCliSelecionada;
	}

	public void setAtividadeForCliSelecionada(
			AtividadeForCli atividadeForCliSelecionada) {
		this.atividadeForCliSelecionada = atividadeForCliSelecionada;
	}

	public AtividadeForCliService getAtividadeForCliService() {
		return atividadeForCliService;
	}

	public void setAtividadeForCliService(
			AtividadeForCliService atividadeForCliService) {
		this.atividadeForCliService = atividadeForCliService;
	}

	public LazyDataModel<AtividadeForCli> getLazyModel() {
		return lazyModel;
	}
}
