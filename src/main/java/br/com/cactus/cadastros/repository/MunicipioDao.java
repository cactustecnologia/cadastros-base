package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.Municipio;

public class MunicipioDao extends GenericRepositoryDaoImpl<Municipio> implements Serializable {

	private static final long serialVersionUID = 1L;

	public Municipio guardar(Municipio municipio){
		if(municipio.getId() == null){
			return this.salvar(municipio);
		}else{
			return this.atualizar(municipio);
		}
	}
	
	public Municipio porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from municipio where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}	
}
