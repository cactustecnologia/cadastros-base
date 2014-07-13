package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.SituacaoForCli;

public class SituacaoForCliDao extends GenericRepositoryDaoImpl<SituacaoForCli> 
	implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public SituacaoForCli guardar(SituacaoForCli situacaoForCli){
		if(situacaoForCli.getId() == null){
			return this.salvar(situacaoForCli);
		}else{
			return this.atualizar(situacaoForCli);					
		}
	}
	
	public SituacaoForCli porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from SituacaoForCli where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}

}
