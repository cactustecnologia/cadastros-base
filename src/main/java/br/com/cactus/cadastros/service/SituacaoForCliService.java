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
import br.com.cactus.cadastros.model.SituacaoForCli;
import br.com.cactus.cadastros.repository.SituacaoForCliDao;
import br.com.cactus.cadastros.repository.filter.SituacaoForCliFilter;
import br.com.cactus.cadastros.util.jpa.Transactional;

public class SituacaoForCliService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SituacaoForCliDao situacaoForCliDao;
	private List<Criterion> params;	
	private LazyDataModel<SituacaoForCli> lazyModel;
	
	public LazyDataModel<SituacaoForCli> filtrados(SituacaoForCliFilter filtro){
		params = new ArrayList<>();
		if(StringUtils.isNotBlank(filtro.getNome())){
			params.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getDescricao())){
			params.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		return lazyModel = new LazyDataModelBase<>(situacaoForCliDao, params, null);
	}	
	
	@Transactional
	public SituacaoForCli salvar(SituacaoForCli situacaoForCli) {
		if (situacaoForCli.getId() == null) {
			SituacaoForCli situacaoForCliExistente = situacaoForCliDao.porNome(situacaoForCli.getNome());
			if (situacaoForCliExistente != null && !situacaoForCliExistente.equals(situacaoForCli)) {
				throw new NegocioException(
						"Já existe uma situação fornecedor cliente com esse nome informado.");
			}
		}
		return situacaoForCliDao.guardar(situacaoForCli);
	}
	
	@Transactional
	public void remover(SituacaoForCli situacaoForCli) {
		try {
			situacaoForCli = situacaoForCliDao.pesquisarPorId(situacaoForCli.getId());
			situacaoForCliDao.excluir(situacaoForCli);
		} catch (PersistenceException e) {
			throw new NegocioException("Esta situação fornecedor cliente não pode ser excluído.");
		}
	}

	//GETTER AND SETTER
	public LazyDataModel<SituacaoForCli> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<SituacaoForCli> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
