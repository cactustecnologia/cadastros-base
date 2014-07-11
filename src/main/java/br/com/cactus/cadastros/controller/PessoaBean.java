package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	@Inject
	private PessoaDao dao;
	
	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.pessoa = new Pessoa();
	}

	@Transactional
	public void salvar(){
		if (pessoa.getId() == null) {
			dao.salvar(pessoa);
			FacesUtil.addInfoMessage("Pessoa salvo com sucesso!");
		} else {
			dao.atualizar(pessoa);
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
	
	
}
