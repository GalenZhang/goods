package com.sofans.dao.sys;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sofans.entity.IBean;
import com.sofans.entity.PageCondition;
import com.sofans.entity.PageResult;

@Repository("commonDAO")
@Transactional
public class CommonDAO {
	private static final Log log = LogFactory.getLog(CommonDAO.class);

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Save entity.
	 * 
	 * @param entity
	 */
	public int save(IBean entity) throws Exception {
		log.debug("save entity");
		try {
			Serializable id = getCurrentSession().save(entity);
			log.debug("save successful");
			return (Integer) id;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(IBean entity) throws Exception {
		log.debug("deleting entity");
		try {
			getCurrentSession().delete(entity);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(IBean entity){
		log.debug("updata entity");
		try {
			getCurrentSession().update(entity);
		} catch (RuntimeException re) {
			throw re;
		}
		
	}
	

	public void deleteByProperty(String propertyName, Object value,
			Class<?> clazz) throws Exception {

		log.debug("deleting instance");
		try {
			Query createQuery = getCurrentSession().createQuery(
					"delete " + clazz.getName() + " where " + propertyName
							+ " = ?");
			createQuery.setParameter(0, value);
			createQuery.executeUpdate();

			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	public IBean findById(int id, Class<?> clazz) throws Exception {
		log.debug("getting entity instance with id: " + id);
		try {

			IBean object = (IBean) getCurrentSession().get(clazz, id);
			return object;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value, Class<?> clazz)
			throws Exception {
		log.debug("finding T instance with property: " + propertyName
				+ ", value: " + value);

		try {
			String queryString = "from " + clazz.getSimpleName()
					+ " as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);

			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findNotInProperty(String propertyName, Object value,
			Class<?> clazz) throws Exception {
		try {
			String queryString = "from " + clazz.getSimpleName()
					+ " as model where model." + propertyName + "!= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}

	@SuppressWarnings("rawtypes")
	public List findAll(Class<?> clazz) throws Exception {
		log.debug("finding all Customer instances");
		try {
			String queryString = "from " + clazz.getSimpleName();
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PageResult page(Class<?> clazz, PageCondition pageCondition)
			throws Exception {
		StringBuilder sql = new StringBuilder("from ");
		sql.append(clazz.getSimpleName());
		sql.append(" as model ");
		Map<String, Object> conditions = pageCondition.getConditions();
		if (conditions != null && !conditions.isEmpty()) {
			sql.append(" where ");
			for (Map.Entry<String, Object> entry : conditions.entrySet()) {
				sql.append(" model.");
				sql.append(entry.getKey());
				sql.append(" = ?");
			}
		}

		Query q = getCurrentSession().createQuery(sql.toString());
		if (conditions != null && !conditions.isEmpty()) {
			int i = 0;
			for (Map.Entry<String, Object> entry : conditions.entrySet()) {
				setCondition(q, i++, entry.getValue());
			}
		}
		q.setFirstResult(pageCondition.getStart());
		q.setMaxResults(pageCondition.getLimit());

		@SuppressWarnings("unchecked")
		PageResult pageResult = new PageResult(true, "Query sucessful",
				q.list());
		int totalSize = countByCondition(conditions, clazz);
		pageResult.setTotalSize(totalSize);
		int pagesize = pageResult.getPagesize();

		int pages = totalSize % pagesize == 0 ? totalSize / pagesize
				: totalSize / pagesize + 1;
		pageResult.setPages(pages);

		return pageResult;
	}

	private int countByCondition(Map<String, Object> conditions, Class<?> clazz)
			throws Exception {
		StringBuilder sql = new StringBuilder("select count(*) from ");
		sql.append(clazz.getSimpleName());
		sql.append(" as model ");
		if (conditions != null && !conditions.isEmpty()) {
			sql.append(" where ");
			for (Map.Entry<String, Object> entry : conditions.entrySet()) {
				sql.append(" model.");
				sql.append(entry.getKey());
				sql.append(" = ?");
			}
		}

		Query q = getCurrentSession().createQuery(sql.toString());
		if (conditions != null && !conditions.isEmpty()) {
			int i = 0;
			for (Map.Entry<String, Object> entry : conditions.entrySet()) {
				setCondition(q, i++, entry.getValue());
			}
		}
		Object next = q.iterate().next();
		return ((Long) next).intValue();
	}

	private void setCondition(Query q, int index, Object value)
			throws Exception {
		if (value instanceof String) {
			q.setString(index, String.valueOf(value));
		} else if (value instanceof Integer) {
			q.setInteger(index, (Integer) value);
		}
	}

	public IBean merge(IBean entity) throws Exception {
		log.debug("merging Customer instance");
		try {
			IBean result = (IBean) getCurrentSession().merge(entity);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public int count(String propertyName, Object value, Class<?> clazz)
			throws Exception {
		Query createQuery = getCurrentSession().createQuery(
				"select count(*) from " + clazz.getSimpleName()
						+ " as model where " + propertyName + "= ?");
		createQuery.setParameter(0, value);
		Object next = createQuery.iterate().next();
		return ((Long) next).intValue();
	}
	

	

	/*
	 * *****************************************以下是 我添加的
	 * ******************************************
	 */

	/*
	 * 查询最大id值
	 */
	public int infoCount(Class<?> clazz) {
		int totalRows = 0;
		Query createQuery = null;
		try {
			createQuery = getCurrentSession().createQuery(
					"select max(id) from " + clazz.getSimpleName());
			totalRows = createQuery.uniqueResult() == null ? 1 : new Integer(
					createQuery.uniqueResult().toString()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalRows;
	}

}
