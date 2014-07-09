package br.com.cactus.cadastros.lazy;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.criterion.Criterion;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.cactus.cadastros.repository.GenericRepositoryDao;

public class LazyDataModelBase<T> extends LazyDataModel<T> {
    
	private static final long serialVersionUID = 1L;

	private final static Logger log = Logger.getLogger(LazyDataModelBase.class.getName());
    
    private volatile GenericRepositoryDao<T> facade;
    List<Criterion> filtros;
    Map<String, String> alias;
    
    public LazyDataModelBase(GenericRepositoryDao<T> facade, List<Criterion> filtros, Map<String, String> alias) {
        super();        
        this.facade = facade;
        this.filtros = filtros;
        this.alias = alias;
    }

    public final GenericRepositoryDao<T> getFacade() {
        return facade;
    }

    public final void setFacade(GenericRepositoryDao<T> facade) {
        this.facade = facade;
    }

    @SuppressWarnings("unused")
	@Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        List<T> list = facade.listaFiltradaCriteria(first, pageSize, sortField, sortOrder, filtros, alias);
        log.log(Level.INFO, "list.size():{0}", String.valueOf(list.size()));
        if (list == null) {
            setRowCount(0);            
        } else {
            setRowCount(facade.contaListaFiltradaCriteria(filtros, alias));
        }
        return list;
    }    
}