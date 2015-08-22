package top.duyt.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import top.duyt.dao.IBaseDao;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class<T> clz;

	//@Inject("sessionFactory")
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private Class<T> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<T>) (((ParameterizedType) (this.getClass()
					.getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public int add(T t) {
		return (Integer) this.getHibernateTemplate().save(t);
	}

	public void delete(int id) {
		this.getHibernateTemplate().delete(this.load(id));
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public int addObj(Object obj) {
		return (Integer) this.getHibernateTemplate().save(obj);
	}

	public void deleteObj(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}

	public void updateObj(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

	public T get(int id) {
		return this.getHibernateTemplate().get(getClz(), id);
	}
	
	public T load(int id) {
		return this.getHibernateTemplate().load(getClz(), id);
	}

	private Query setParams(String hql, Object[] params) {
		Query q = this.getSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				q.setParameter(i, params[i]);
			}
		}
		return q;
	}

	public List<T> list(String hql, Object[] params) {
		return setParams(hql, params).list();
	}

	public List<T> list(String hql, Object param) {
		return this.list(hql, new Object[] { param });
	}

	public List<T> list(String hql) {
		return this.list(hql, null);
	}

	public List<Object> listObjs(String hql, Object[] params) {
		return setParams(hql, params).list();
	}

	public List<Object> listObjs(String hql, Object param) {
		return this.listObjs(hql, new Object[] { param });
	}

	public List<Object> listObjs(String hql) {
		return this.listObjs(hql, null);
	}

	private String getCountHql(String hql) {

		String s = hql.substring(0, hql.indexOf("from"));
		if (s == null || s.trim().equals("")) {
			hql = "select count(*) " + hql;
		} else {
			hql = hql.replace(s, "select count(*) ");
		}
		hql = hql.replace("fetch", "");
		return hql;

	}

	public Pager<T> find(String hql, Object[] params) {
		
		Pager<T> pager = new Pager<T>();
		int pageSize = SystemContext.getPageSize();
		int offset = SystemContext.getPageOffset();
		
		if (pageSize == 0) {
			pageSize = 10;
		}
		
		pager.setPageOffset(offset);
		pager.setPageSize(pageSize);
		
		//查询数据
		Query q = setParams(hql, params);
		q.setFirstResult(offset).setMaxResults(pageSize);
		pager.setDatas(q.list());
		
		//查询记录数
		String ctHql = getCountHql(hql);
		Query cq = setParams(ctHql, params);
		int totalCount = Integer.valueOf(cq.uniqueResult().toString());
		pager.setTotalPageRecord(totalCount);
		
		return pager;
	}

	public Pager<T> find(String hql, Object param) {
		return this.find(hql, new Object[]{param});
	}

	public Pager<T> find(String hql) {
		return this.find(hql, null);
	}

	public Pager<Object> findObjs(String hql, Object[] params) {
		Pager<Object> pager = new Pager<Object>();
		int pageSize = SystemContext.getPageSize();
		int offset = SystemContext.getPageOffset();
		
		if (pageSize == 0) {
			pageSize = 10;
		}
		if (offset == 0) {
			offset = 10;
		}
		
		pager.setPageOffset(offset);
		pager.setPageSize(pageSize);
		
		//查询数据
		Query q = setParams(hql, params);
		q.setFirstResult(offset).setMaxResults(pageSize);
		pager.setDatas(q.list());
		
		//查询记录数
		String ctHql = getCountHql(hql);
		Query cq = setParams(ctHql, params);
		int totalCount = (Integer) cq.uniqueResult();
		pager.setTotalPageRecord(totalCount);
		
		return pager;
	}

	public Pager<Object> findObjs(String hql, Object param) {
		return this.findObjs(hql, new Object[]{param});
	}

	public Pager<Object> findObjs(String hql) {
		return this.findObjs(hql, null);
	}

	public Object queryByHql(String hql, Object[] params) {
		return setParams(hql, params).uniqueResult();
	}

	public Object queryByHql(String hql, Object param) {
		return this.queryByHql(hql,new Object[]{param});
	}

	public Object queryByHql(String hql) {
		return this.queryByHql(hql,null);
	}

	public void executeByHql(String hql, Object[] params) {
		setParams(hql, params).executeUpdate();
	}

	public void executeByHql(String hql, Object param) {
		executeByHql(hql,new Object[]{param});

	}

	public void executeByHql(String hql) {
		executeByHql(hql,null);
	}

}
