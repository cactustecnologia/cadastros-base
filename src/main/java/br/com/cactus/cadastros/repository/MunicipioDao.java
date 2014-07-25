package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.cactus.cadastros.model.Municipio;
import br.com.cactus.cadastros.model.Uf;

public class MunicipioDao extends GenericRepositoryDaoImpl<Municipio> implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Criterion> params;
	
	private Map<String, String> alias = new HashMap<>();

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
	
	public List<Municipio> consultaCidades(Uf uf) {
		List<Municipio> municipios;
		alias.put("uf", "uf");
		params = new ArrayList<>();
		if(uf != null){
			params.add(Restrictions.eq("uf.nome", uf.getNome()));
		}
		municipios = findByCriteria(params, alias);;
		return municipios;
	}
}
