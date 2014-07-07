package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.repository.Pessoas;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	
	@Inject
	private Pessoas pessoas;
	
	public void limpar(){
		this.pessoa = new Pessoa();
	}

	@Transactional
	public void salvar(){
		if (pessoa.getId() == null) {
			pessoas.salvar(pessoa);
			FacesUtil.addInfoMessage("Pessoa salvo com sucesso!");
		} else {
			pessoas.atualizar(pessoa);
			FacesUtil.addInfoMessage("Pessoa atualizada com sucesso!");
		}
		limpar();
	}
	
	
	//getter and setter
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
