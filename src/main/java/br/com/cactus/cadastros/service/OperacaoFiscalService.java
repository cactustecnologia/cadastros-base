package br.com.cactus.cadastros.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.lazy.LazyDataModelBase;
import br.com.cactus.cadastros.model.OperacaoFiscal;
import br.com.cactus.cadastros.repository.OperacaoFiscalDao;

public class OperacaoFiscalService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LazyDataModel<OperacaoFiscal> lazyModel;
	private List<Criterion> params;
	//private Map<String, String> alias = new HashMap<>();
	@Inject
	private OperacaoFiscalDao operacaoFiscalDao;
	
	public LazyDataModel<OperacaoFiscal> filtrados(String descricao) {
		params = new ArrayList<>();
		
		if(StringUtils.isNotBlank(descricao)){
			params.add(Restrictions.ilike("descricao", descricao, MatchMode.ANYWHERE));
		}		
		return lazyModel = new LazyDataModelBase<>(operacaoFiscalDao, params, null);
	}
	
	//GETTER AND SETTER
	public LazyDataModel<OperacaoFiscal> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<OperacaoFiscal> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
