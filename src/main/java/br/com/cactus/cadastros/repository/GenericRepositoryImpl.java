package br.com.cactus.cadastros.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;

public class GenericRepositoryImpl<T> implements GenericRepository<T>, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;	
	
	private Session session;
	private Criteria criteria;	
	private final Class<T> oClass;

	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getObjectClass() {
		return this.oClass;
	}

	public T salvar(T object) {
		entityManager.clear();
		entityManager.persist(object);
		return object;
	}

	public T pesquisarPorId(Long id) {
		return (T) getEntityManager().find(oClass, id);
	}

	public T atualizar(T object) {		
		return entityManager.merge(object);
	}

	public void excluir(T object) {
		object = entityManager.merge(object);
		entityManager.remove(object);
		entityManager.flush();

	}

	public List<T> todos() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(oClass);
		Root<T> root = cq.from(oClass);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(List<Criterion> params) {
		session = entityManager.unwrap(Session.class);
		criteria = session.createCriteria(oClass);
		for (Criterion criterion : params) {
			criteria.add(criterion);
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params) {
		Query q = entityManager.createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesq(String query) {
		Query q = entityManager.createQuery(query);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T pesqParam(String query, Map<String, Object> params) {
		Query q = entityManager.createQuery(query);

		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));
		}

		try {
			return (T) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager()
				.getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(oClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listaFiltradaCriteria(int first, int count,
			String sortField, SortOrder sortOrder, List<Criterion> params,
			Map<String, String> alias) {
		session = entityManager.unwrap(Session.class);
		criteria = session.createCriteria(oClass);
		if (alias != null) {
			for (String chave : alias.keySet()) {
				criteria.createAlias(alias.get(chave), alias.get(chave));
			}
		}
		for (Criterion criterion : params) {
			criteria.add(criterion);
		}
		criteria.setFirstResult(first);
		criteria.setMaxResults(count);
		return criteria.list();
	}

	@Override
	public int contaListaFiltradaCriteria(List<Criterion> params,
			Map<String, String> alias) {
		session = entityManager.unwrap(Session.class);
		criteria = session.createCriteria(oClass)
				.setProjection(Projections.rowCount());
		if (alias != null) {
			for (String chave : alias.keySet()) {
				criteria.createAlias(alias.get(chave), alias.get(chave));
			}
		}
		for (Criterion criterion : params) {
			criteria.add(criterion);
		}
		return ((Long) criteria.uniqueResult()).intValue();
	}

	// getter and setter
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

}
