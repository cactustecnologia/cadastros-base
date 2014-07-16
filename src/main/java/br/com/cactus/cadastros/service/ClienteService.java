package br.com.cactus.cadastros.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.LazyDataModel;

import br.com.cactus.cadastros.lazy.LazyDataModelBase;
import br.com.cactus.cadastros.model.Cliente;
import br.com.cactus.cadastros.repository.ClienteDao;
import br.com.cactus.cadastros.repository.filter.ClienteFilter;
import br.com.cactus.cadastros.util.jpa.Transactional;

public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteDao clienteDao;
	private List<Criterion> params;	
	private LazyDataModel<Cliente> lazyModel;
	private Map<String, String> alias = new HashMap<>();
	private List<Cliente> clientePessoaPorNome;
	
	public LazyDataModel<Cliente> filtrados(ClienteFilter filtro) {
		params = new ArrayList<>();
		
		alias.put("pessoa", "pessoa");
		alias.put("situacaoForCli", "situacaoForCli");
		alias.put("atividadeForCli", "atividadeForCli");
		
		if(filtro.getDesde() != null){
			params.add(Restrictions.ge("desde", filtro.getDesde()));
		}
		if(filtro.getLimiteCredito() != null){
			params.add(Restrictions.ge("limiteCredito", filtro.getLimiteCredito()));
		}
		if(StringUtils.isNotBlank(filtro.getNome())){
			params.add(Restrictions.ilike("pessoa.nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getAtividadeForCli())){
			params.add(Restrictions.ilike("atividadeForCli.nome", filtro.getAtividadeForCli(), MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotBlank(filtro.getSituacaoForCli())){
			params.add(Restrictions.ilike("situacaoForCli.nome", filtro.getSituacaoForCli(), MatchMode.ANYWHERE));
		}
		
		return lazyModel = new LazyDataModelBase<>(clienteDao, params, alias);
	}
	

	
	public List<Cliente> porNome(String nome){
		params = new ArrayList<>();
		alias.put("pessoa", "pessoa");
		if(StringUtils.isNotBlank(nome)){
			params.add(Restrictions.ilike("pessoa.nome", nome, MatchMode.ANYWHERE));
		}
        clientePessoaPorNome = this.clienteDao.findByCriteria(params, alias);
		return clientePessoaPorNome;
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteDao.guardar(cliente);
	}
	
	@Transactional
	public void remover(Cliente cliente) {
		try {
			cliente = clienteDao.pesquisarPorId(cliente.getId());
			clienteDao.excluir(cliente);
		} catch (PersistenceException e) {
			throw new NegocioException("Este cliente não pode ser excluído.");
		}
	}

	//GETTER AND SETTER
	public LazyDataModel<Cliente> getLazyModel() {
		return lazyModel;
	}

	public void setLazyModel(LazyDataModel<Cliente> lazyModel) {
		this.lazyModel = lazyModel;
	}
}
