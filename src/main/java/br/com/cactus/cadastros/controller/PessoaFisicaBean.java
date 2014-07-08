package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.PessoaFisica;
import br.com.cactus.cadastros.repository.PessoaFisicaDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaFisica pessoaFisica;
	
	@Inject
	private PessoaFisicaDao dao;
	
	public void limpar(){
		this.pessoaFisica = new PessoaFisica();
	}
	
	@Transactional
	public void salvar(){
		if (pessoaFisica.getId() == null) {
			dao.salvar(pessoaFisica);
			FacesUtil.addInfoMessage("Pessoa Física salva com sucesso!");
		} else {
			dao.atualizar(pessoaFisica);
			FacesUtil.addInfoMessage("Pessoa Física atualizada com sucesso!");
		}
		limpar();
	}

	
	//getter and setter
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
}
