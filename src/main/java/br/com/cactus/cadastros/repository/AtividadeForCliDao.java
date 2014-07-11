package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.AtividadeForCli;

public class AtividadeForCliDao extends GenericRepositoryDaoImpl<AtividadeForCli> 
	implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AtividadeForCli guardar(AtividadeForCli atividadeForCli){
		if(atividadeForCli.getId() == null){
			return this.salvar(atividadeForCli);
		}else{
			return this.atualizar(atividadeForCli);
		}
	}
	
	public AtividadeForCli porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from AtividadeForCli where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}

}
