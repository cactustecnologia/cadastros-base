package br.com.cactus.cadastros.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.lazy.LazyDataModelBase;
import br.com.cactus.cadastros.model.Pessoa;
import br.com.cactus.cadastros.model.PessoaFisica;
import br.com.cactus.cadastros.model.PessoaJuridica;
import br.com.cactus.cadastros.model.TipoPessoa;
import br.com.cactus.cadastros.repository.PessoaDao;
import br.com.cactus.cadastros.repository.PessoaFisicaDao;
import br.com.cactus.cadastros.repository.PessoaJuridicaDao;
import br.com.cactus.cadastros.repository.filter.PessoaFisicaFilter;
import br.com.cactus.cadastros.repository.filter.PessoaJuridicaFilter;
import br.com.cactus.cadastros.util.jpa.Transactional;

public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDao pessoaDao;
	@Inject
	private PessoaFisicaDao pessoaFisicaDao;
	@Inject
	private PessoaJuridicaDao pessoaJuridicaDao;
	private List<Criterion> params;	
	private LazyDataModel<PessoaFisica> lazyModelFisica;
	private LazyDataModel<PessoaJuridica> lazyModelJuridica;
	
	public LazyDataModel<PessoaFisica> filtrados(PessoaFisicaFilter filtro){
		params = new ArrayList<>();
		if(StringUtils.isNotBlank(filtro.getCpf())){
			params.add(Restrictions.ilike("cpf", filtro.getCpf(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getRg())){
			params.add(Restrictions.ilike("rg", filtro.getRg(), MatchMode.ANYWHERE));
		}
		return lazyModelFisica = new LazyDataModelBase<>(pessoaFisicaDao, params, null);
	}
	
	public LazyDataModel<PessoaJuridica> filtradosJuridica(PessoaJuridicaFilter filtroJuridica){
		params = new ArrayList<>();
		if(StringUtils.isNotBlank(filtroJuridica.getCnpj())){
			params.add(Restrictions.ilike("cnpj", filtroJuridica.getCnpj(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtroJuridica.getFantasia())){
			params.add(Restrictions.ilike("fantasia", filtroJuridica.getFantasia(), MatchMode.ANYWHERE));
		}
		return lazyModelJuridica = new LazyDataModelBase<>(pessoaJuridicaDao, params, null);
	}
	
	@Transactional
	public Pessoa salvar(Pessoa pessoa, PessoaFisica pessoaFisica, PessoaJuridica pessoaJuridica) {
		pessoa = pessoaDao.guardar(pessoa);
		if(TipoPessoa.FISICA.equals(pessoa.getTipo())){
			pessoaFisica.setPessoa(pessoa);
			pessoaFisicaDao.atualizar(pessoaFisica);
		}
		if (TipoPessoa.JURIDICA.equals(pessoa.getTipo())){
			pessoaJuridica.setPessoa(pessoa);
			pessoaJuridicaDao.atualizar(pessoaJuridica);
		}
		return pessoa;
	}
	
	@Transactional
	public void remover(Pessoa pessoa) {
		try {
			pessoa = pessoaDao.pesquisarPorId(pessoa.getId());
			pessoaDao.excluir(pessoa);
		} catch (PersistenceException e) {
			throw new NegocioException("Esta pessoa não pode ser excluída!");
		}
	}	
	
	//getter and setter
	public LazyDataModel<PessoaFisica> getLazyModelFisica() {
		return lazyModelFisica;
	}

	public void setLazyModelFisica(LazyDataModel<PessoaFisica> lazyModelFisica) {
		this.lazyModelFisica = lazyModelFisica;
	}

	public LazyDataModel<PessoaJuridica> getLazyModelJuridica() {
		return lazyModelJuridica;
	}

	public void setLazyModelJuridica(LazyDataModel<PessoaJuridica> lazyModelJuridica) {
		this.lazyModelJuridica = lazyModelJuridica;
	}

}
