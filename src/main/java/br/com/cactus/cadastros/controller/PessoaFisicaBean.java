package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.PessoaFisica;
import br.com.cactus.cadastros.repository.PessoaFisicas;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaFisica pessoaFisica;
	
	@Inject
	private PessoaFisicas pessoaFisicas;
	
	public void limpar(){
		this.pessoaFisica = new PessoaFisica();
	}
	
	@Transactional
	public void salvar(){
		if (pessoaFisica.getId() == null) {
			pessoaFisicas.salvar(pessoaFisica);
			FacesUtil.addInfoMessage("Pessoa Física salva com sucesso!");
		} else {
			pessoaFisicas.atualizar(pessoaFisica);
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
