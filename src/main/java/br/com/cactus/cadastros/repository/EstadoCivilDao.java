package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.EstadoCivil;

public class EstadoCivilDao extends GenericRepositoryDaoImpl<EstadoCivil> 
	implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public EstadoCivil guardar(EstadoCivil civil){
		if(civil.getId() == null){
			return this.salvar(civil);
		}else{
			return this.atualizar(civil);
		}
	}
	
	public EstadoCivil porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from EstadoCivil where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}	
}
