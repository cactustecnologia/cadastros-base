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
import br.com.cactus.cadastros.model.AtividadeForCli;
import br.com.cactus.cadastros.repository.AtividadeForCliDao;
import br.com.cactus.cadastros.repository.filter.AtividadeForCliFilter;
import br.com.cactus.cadastros.util.jpa.Transactional;

public class AtividadeForCliService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AtividadeForCliDao atividadeForCliDao;
	private List<Criterion> params;	
	private LazyDataModel<AtividadeForCli> lazyModel;
	
	public LazyDataModel<AtividadeForCli> filtrados(AtividadeForCliFilter filtro){
		params = new ArrayList<>();
		if(StringUtils.isNotBlank(filtro.getNome())){
			params.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getDescricao())){
			params.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		return lazyModel = new LazyDataModelBase<>(atividadeForCliDao, params, null);
	}	
	
	@Transactional
	public AtividadeForCli salvar(AtividadeForCli atividadeForCli) {
		if (atividadeForCli.getId() == null) {
			AtividadeForCli atividadeForCliExistente = atividadeForCliDao.porNome(atividadeForCli.getNome());
			if (atividadeForCliExistente != null && !atividadeForCliExistente.equals(atividadeForCli)) {
				throw new NegocioException(
						"Já existe uma atividade fornecedor cliente com esse nome informado.");
			}
		}
		return atividadeForCliDao.guardar(atividadeForCli);
	}
	
	@Transactional
	public void remover(AtividadeForCli atividadeForCli) {
		try {
			atividadeForCli = atividadeForCliDao.pesquisarPorId(atividadeForCli.getId());
			atividadeForCliDao.excluir(atividadeForCli);
		} catch (PersistenceException e) {
			throw new NegocioException("Esta atividade fornecedor cliente não pode ser excluído.");
		}
	}	
	
	//getter and setter
	public LazyDataModel<AtividadeForCli> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<AtividadeForCli> lazyModel) {
		this.lazyModel = lazyModel;
	}

}
