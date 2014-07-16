package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.cactus.cadastros.model.Pessoa;

public class PessoaDao extends GenericRepositoryDaoImpl<Pessoa> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Criterion> params;	
	private List<Pessoa> listaPessoas;
	
	public List<Pessoa> porNome(String nome){
		params = new ArrayList<>();		
		if(StringUtils.isNotBlank(nome)){
			params.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
		}
        listaPessoas = this.findByCriteria(params, null);
		return listaPessoas;
	}
}
