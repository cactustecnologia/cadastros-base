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
import br.com.cactus.cadastros.model.EstadoCivil;
import br.com.cactus.cadastros.repository.EstadoCivilDao;
import br.com.cactus.cadastros.repository.filter.EstadoCivilFilter;
import br.com.cactus.cadastros.util.jpa.Transactional;

public class EstadoCivilService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EstadoCivilDao civilDao;
	private List<Criterion> params;	
	private LazyDataModel<EstadoCivil> lazyModel;
	
	public LazyDataModel<EstadoCivil> filtrados(EstadoCivilFilter filtro){
		params = new ArrayList<>();
		if(StringUtils.isNotBlank(filtro.getNome())){
			params.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getDescricao())){
			params.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
		}
		return lazyModel = new LazyDataModelBase<>(civilDao, params, null);
	}	
	
	@Transactional
	public EstadoCivil salvar(EstadoCivil estadoCivil) {
		if (estadoCivil.getId() == null) {
			EstadoCivil estadoCivilExistente = civilDao.porNome(estadoCivil.getNome());
			if (estadoCivilExistente != null && !estadoCivilExistente.equals(estadoCivil)) {
				throw new NegocioException(
						"Já existe um estado Civil com esse nome informado.");
			}
		}
		return civilDao.guardar(estadoCivil);
	}
	
	@Transactional
	public void remover(EstadoCivil estadoCivil) {
		try {
			estadoCivil = civilDao.pesquisarPorId(estadoCivil.getId());
			civilDao.excluir(estadoCivil);
		} catch (PersistenceException e) {
			throw new NegocioException("Este estado civil não pode ser excluído.");
		}
	}	
	
	//getter and setter
	public LazyDataModel<EstadoCivil> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<EstadoCivil> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
