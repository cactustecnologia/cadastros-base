package br.com.cactus.cadastros.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.Cliente;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.repository.filter.AtividadeForCliFilter;
import br.com.cactus.cadastros.service.AtividadeForCliService;
import br.com.cactus.cadastros.service.ClienteService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;	
	private AtividadeForCli atividadeSelecionada;
	private LazyDataModel<AtividadeForCli> lazyAtividade;
	private AtividadeForCliFilter filtroAtividade;
	@Inject
	private ClienteService clienteService;
	@Inject
	private PessoaDao pessoaDao;
	@Inject
	private AtividadeForCliService atividadeService;
		
	@PostConstruct
	public void init(){
		limpar();		
	}
	
	public void inicializar(){
		System.out.println("Inicializando...");
		if (FacesUtil.isNotPostback()){
			pesquisarAtividade();
		}		
	}
	
	public void limpar(){
		this.cliente = new Cliente();
		this.limparFiltroAtividade();
	}
	
	public void limparFiltroAtividade(){
		this.filtroAtividade = new AtividadeForCliFilter();
	}
	
	public void salvar(){
		this.cliente = clienteService.salvar(cliente);
		limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public void pesquisarAtividade(){
		lazyAtividade = atividadeService.filtrados(filtroAtividade);
	}
	
	public List<Pessoa> completarPessoa(String nome){
		return pessoaDao.porNome(nome);
	}
			
	public void selecionarAtividade(){
		this.cliente.setAtividadeForCli(atividadeSelecionada);
		System.out.println("Atividade selecionada: " + this.cliente.getAtividadeForCli().getNome());
	}
	
	public void handleAtividadeClose(CloseEvent event) {
		filtroAtividade = new AtividadeForCliFilter();
		System.out.println("chamou fechar");
		
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
}
