package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.Cliente;
import br.com.cactus.cadastros.model.OperacaoFiscal;
import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.repository.filter.AtividadeForCliFilter;
import br.com.cactus.cadastros.repository.filter.SituacaoForCliFilter;
import br.com.cactus.cadastros.service.AtividadeForCliService;
import br.com.cactus.cadastros.service.ClienteService;
import br.com.cactus.cadastros.service.OperacaoFiscalService;
import br.com.cactus.cadastros.service.SituacaoForCliService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;	
	
	private AtividadeForCli atividadeSelecionada;
	private SituacaoForCli situacaoSelecionada;
	private OperacaoFiscal operacaoFiscalSelecionada;
	
	private LazyDataModel<AtividadeForCli> lazyAtividade;
	private LazyDataModel<SituacaoForCli> lazySituacao;
	private LazyDataModel<OperacaoFiscal> lazyOperacaoFiscal;
	
	private AtividadeForCliFilter filtroAtividade;
	private SituacaoForCliFilter filtroSituacao;
	private String descricaoOperacao;
	
	@Inject
	private ClienteService clienteService;	
	@Inject
	private AtividadeForCliService atividadeService;
	@Inject
	private SituacaoForCliService situacaoService;
	@Inject
	private OperacaoFiscalService operacaoFiscalService;
		
	@PostConstruct
	public void init(){
		limpar();		
	}
	
	public void inicializar(){
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()){
			pesquisarAtividade();
			pesquisarSituacao();
			pesquisarOperacaoFiscal();
		}		
	}

	public void limpar(){
		this.cliente = new Cliente();
		this.limparFiltroAtividade();
		this.limparFiltroSituacao();
		this.limparFiltroOperacaoFiscal();
	}
	
	public void limparFiltroAtividade(){
		this.filtroAtividade = new AtividadeForCliFilter();
	}
	
	public void limparFiltroSituacao(){
		this.filtroSituacao = new SituacaoForCliFilter();
	}
	
	public void limparFiltroOperacaoFiscal(){
		this.setDescricaoOperacao("");
	}
	
	public void salvar(){
		this.cliente = clienteService.salvar(cliente);
		limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public void pesquisarAtividade(){
		lazyAtividade = atividadeService.filtrados(filtroAtividade);
	}	
	
	public void pesquisarSituacao(){
		lazySituacao = situacaoService.filtrados(filtroSituacao);
	}
	
	private void pesquisarOperacaoFiscal() {		
		lazyOperacaoFiscal = operacaoFiscalService.filtrados(descricaoOperacao);				
	}
				
	public void selecionarAtividade(){
		this.cliente.setAtividadeForCli(atividadeSelecionada);		
	}
	
	public void selecionarSituacao(){
		this.cliente.setSituacaoForCli(situacaoSelecionada);
	}
	
	public void selecionarOperacaoFiscal(){
		this.cliente.setOperacaoFiscal(operacaoFiscalSelecionada);
	}
	
	public void handleAtividadeClose(CloseEvent event) {
		filtroAtividade = new AtividadeForCliFilter();		
	}
	
	public void handleSituacaoClose(CloseEvent event) {
		filtroSituacao = new SituacaoForCliFilter();		
	}
	
	public void handleOperacaoFiscalClose(CloseEvent event) {
		this.setDescricaoOperacao("");
	}
	
	//GETTER AND SETTER
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

	public AtividadeForCli getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada(AtividadeForCli atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	public AtividadeForCliFilter getFiltroAtividade() {
		return filtroAtividade;
	}

	public void setFiltroAtividade(AtividadeForCliFilter filtroAtividade) {
		this.filtroAtividade = filtroAtividade;
	}

	public LazyDataModel<AtividadeForCli> getLazyAtividade() {
		return lazyAtividade;
	}

	public SituacaoForCli getSituacaoSelecionada() {
		return situacaoSelecionada;
	}

	public void setSituacaoSelecionada(SituacaoForCli situacaoSelecionada) {
		this.situacaoSelecionada = situacaoSelecionada;
	}

	public SituacaoForCliFilter getFiltroSituacao() {
		return filtroSituacao;
	}

	public void setFiltroSituacao(SituacaoForCliFilter filtroSituacao) {
		this.filtroSituacao = filtroSituacao;
	}

	public LazyDataModel<SituacaoForCli> getLazySituacao() {
		return lazySituacao;
	}

	public String getDescricaoOperacao() {
		return descricaoOperacao;
	}

	public void setDescricaoOperacao(String descricaoOperacao) {
		this.descricaoOperacao = descricaoOperacao;
	}

	public OperacaoFiscal getOperacaoFiscalSelecionada() {
		return operacaoFiscalSelecionada;
	}

	public void setOperacaoFiscalSelecionada(
			OperacaoFiscal operacaoFiscalSelecionada) {
		this.operacaoFiscalSelecionada = operacaoFiscalSelecionada;
	}

	public LazyDataModel<OperacaoFiscal> getLazyOperacaoFiscal() {
		return lazyOperacaoFiscal;
	}	
}
