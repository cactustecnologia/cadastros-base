package br.com.cactus.cadastros.repository;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.primefaces.model.SortOrder;

public interface GenericRepositoryDao<T> {
	
	public Class<T> getObjectClass();

    public T salvar(T object);

    public T pesquisarPorId(Integer id);

    public T atualizar(T object);    
    
    public void excluir(T object);

    public List<T> todos();
    
    public List<T> findByCriteria(List<Criterion> params);    
    
    public List<T> listaFiltradaCriteria(int first, int count, String sortField, SortOrder sortOrder, 
    		List<Criterion> params,Map<String, String> alias);    
    
    public int contaListaFiltradaCriteria(List<Criterion> params, Map<String, String> alias);
        
    public List<T> listPesqParam(String query, Map<String, Object> params);
    
    public List<T> listPesq(String query);

    public T pesqParam(String query, Map<String, Object> params);

}
