package br.com.cactus.cadastros.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cactus.cadastros.model.PessoaJuridica;
import br.com.cactus.cadastros.model.TipoCrt;
import br.com.cactus.cadastros.model.TipoRegime;
import br.com.cactus.cadastros.repository.PessoaJuridicaDao;
import br.com.cactus.cadastros.util.jpa.Transactional;
import br.com.cactus.cadastros.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PessoaJuridicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaJuridica pessoaJuridica;
	
	@Inject
	private PessoaJuridicaDao dao;

	@PostConstruct
	public void init(){
		limpar();
	}
	
	public void limpar(){
		this.pessoaJuridica = new PessoaJuridica();
	}
	
	
	@Transactional
	public void salvar(){
		if (pessoaJuridica.getId() == null) {
			dao.salvar(pessoaJuridica);
			FacesUtil.addInfoMessage("Pessoa Jurídica salva com sucesso");
		} else {
			dao.atualizar(pessoaJuridica);
			FacesUtil.addInfoMessage("Pessoa Jurídica atualizada com sucesso!");
		}
		limpar();
	}
	
	public TipoRegime[] getTiposRegimes() {
	    return TipoRegime.values();
	}
	
	public TipoCrt[] getTiposCrts() {
	    return TipoCrt.values();
	}
	
	//getter and setter
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	
	
}
