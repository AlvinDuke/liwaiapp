package top.duyt.dao;

import java.util.List;

import top.duyt.util.Pager;

public interface IBaseDao<T> {
	
	/**
	 * 泛型CURD
	 */
	
	public int add(T t);
	public void delete(int id);
	public void update(T t);
	
	/**
	 * 对象CURD
	 */
	
	public int addObj(Object obj);
	public void deleteObj(Object obj);
	public void updateObj(Object obj);
	
	public T load(int id);
	public T get(int id);
	
	/**
	 * 使用hql获取一组泛型的对象，不分页
	 */
	
	public List<T> list(String hql,Object[] params);
	public List<T> list(String hql,Object param);
	public List<T> list(String hql);
	
	/**
	 * 使用hql获取一组对象，不分页
	 */
	
	public List<Object> listObjs(String hql,Object[] params);
	public List<Object> listObjs(String hql,Object param);
	public List<Object> listObjs(String hql);
	
	/**
	 * 使用hql获取一组泛型的对象，分页
	 */
	
	public Pager<T> find(String hql,Object[] params);
	public Pager<T> find(String hql,Object param);
	public Pager<T> find(String hql);
	
	/**
	 * 使用hql获取一组对象，分页
	 */
	
	public Pager<Object> findObjs(String hql,Object[] params);
	public Pager<Object> findObjs(String hql,Object param);
	public Pager<Object> findObjs(String hql);
	
	/**
	 * 使用hql获取一个对象
	 */
	
	public Object queryByHql(String hql,Object[] params);
	public Object queryByHql(String hql,Object param);
	public Object queryByHql(String hql);
	
	/**
	 * 使用hql更新一组对象
	 */
	
	public void executeByHql(String hql,Object[] params);
	public void executeByHql(String hql,Object param);
	public void executeByHql(String hql);
	
	

}
