package br.com.cactus.cadastros.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.model.Cliente;
import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.service.ClienteService;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private List<AtividadeForCli> listaAtividadeforCli;
	private List<SituacaoForCli> listaSituacaoForCli;
	@Inject
	private ClienteService clienteService;
		
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.cliente = new Cliente();
	}
	
	public void salvar(){
		this.cliente = clienteService.salvar(cliente);
		limpar();
		FacesUtil.addInfoMessage("Transação efetuada com sucesso.");
	}
	
	public List<Cliente> completarPessoa(String nome){
		return this.clienteService.porNome(nome);
	}
	
	//GETTER AND SETTER
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<AtividadeForCli> getListaAtividadeforCli() {
		return listaAtividadeforCli;
	}

	public List<SituacaoForCli> getListaSituacaoForCli() {
		return listaSituacaoForCli;
	}	
}
