package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;

import br.com.cactus.cadastros.model.Pessoa;

public class PessoaDao extends GenericRepositoryDaoImpl<Pessoa> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Pessoa guardar(Pessoa pessoa){
		if(pessoa.getId() == null){
			return this.salvar(pessoa);
		}else{
			return this.atualizar(pessoa);
		}
	}
	
	public Pessoa porNome(String nome){
		try{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			return pesqParam("from Pessoa where upper(nome) = :nome", params);
		} catch (NoResultException ex){
			return null;
		}
	}	
}
