package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;

import br.com.cactus.cadastros.model.Contato;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.model.TipoPessoa;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Contato contato;
	private Contato contatoSelecionado;	
	@Inject
	private PessoaDao pessoaDao;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){		
		this.pessoa = new Pessoa();
		contato = new Contato();		
	}
		
	@Transactional
	public void salvar(){
		if (pessoa.getId()  == null) {
			pessoaDao.salvar(pessoa);
			FacesUtil.addInfoMessage("Pessoa salvo com sucesso!");
		} else {
			pessoaDao.atualizar(pessoa);
			FacesUtil.addInfoMessage("Pessoa atualizada com sucesso!");
		}
		limpar();
	}	
		
	public void adicionaContato(){
		if(this.contatoSelecionado == null){
			contato.setPessoa(pessoa);			
			this.pessoa.getContatos().add(this.contato);			
		}
		this.limparContato();
	}

	public void limparContato(){
		this.contato = new Contato();
		this.contatoSelecionado = null;
	}
	
	public TipoPessoa[] getTiposPessoas() {
	    return TipoPessoa.values();
	}
	
	public void handleClose(CloseEvent event) {
		if (contato != null) {
			contato = new Contato();
			this.contatoSelecionado = null;
			System.out.println("Chamou o fechar");
		}
	}
	
	//getter and setter
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
	
	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void setContatoSelecionado(Contato contatoSelecionado) {
		this.contatoSelecionado = contatoSelecionado;
	}
}
