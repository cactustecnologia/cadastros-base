package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.Contato;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.model.TipoPessoa;
import br.com.cactus.cadastros.repository.ContatoDao;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Contato contato;
	
	@Inject
	private PessoaDao pessoaDao;
	private ContatoDao contatoDao;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.pessoa = new Pessoa();
	}

	@Transactional
	public void salvar(){
		if (pessoa.getId()  == null && contato.getId() == null) {
			pessoaDao.salvar(pessoa);
			contatoDao.salvar(contato);
			FacesUtil.addInfoMessage("Pessoa salvo com sucesso!");
		} else {
			pessoaDao.atualizar(pessoa);
			contatoDao.atualizar(contato);
			FacesUtil.addInfoMessage("Pessoa atualizada com sucesso!");
		}
		limpar();
	}
	
	public TipoPessoa[] getTiposPessoas() {
	    return TipoPessoa.values();
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
	
	
}
