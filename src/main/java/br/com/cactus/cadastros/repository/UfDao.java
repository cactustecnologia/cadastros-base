package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.Uf;

public class UfDao extends GenericRepositoryDaoImpl<Uf> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Uf guardar(Uf uf){
		if(uf.getId() == null){
			return this.salvar(uf);
		}else{
			return this.atualizar(uf);
		}
	}

	public Uf porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from Uf where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}	
}