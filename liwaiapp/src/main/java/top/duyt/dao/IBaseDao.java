package top.duyt.dao;

import java.util.List;

import top.duyt.util.Pager;

public interface IBaseDao<T> {
	
	/**
	 * ����CURD
	 */
	
	public int add(T t);
	public void delete(int id);
	public void update(T t);
	
	/**
	 * ����CURD
	 */
	
	public int addObj(Object obj);
	public void deleteObj(Object obj);
	public void updateObj(Object obj);
	
	public T load(int id);
	public T get(int id);
	
	/**
	 * ʹ��hql��ȡһ�鷺�͵Ķ��󣬲���ҳ
	 */
	
	public List<T> list(String hql,Object[] params);
	public List<T> list(String hql,Object param);
	public List<T> list(String hql);
	
	/**
	 * ʹ��hql��ȡһ����󣬲���ҳ
	 */
	
	public List<Object> listObjs(String hql,Object[] params);
	public List<Object> listObjs(String hql,Object param);
	public List<Object> listObjs(String hql);
	
	/**
	 * ʹ��hql��ȡһ�鷺�͵Ķ��󣬷�ҳ
	 */
	
	public Pager<T> find(String hql,Object[] params);
	public Pager<T> find(String hql,Object param);
	public Pager<T> find(String hql);
	
	/**
	 * ʹ��hql��ȡһ����󣬷�ҳ
	 */
	
	public Pager<Object> findObjs(String hql,Object[] params);
	public Pager<Object> findObjs(String hql,Object param);
	public Pager<Object> findObjs(String hql);
	
	/**
	 * ʹ��hql��ȡһ������
	 */
	
	public Object queryByHql(String hql,Object[] params);
	public Object queryByHql(String hql,Object param);
	public Object queryByHql(String hql);
	
	/**
	 * ʹ��hql����һ�����
	 */
	
	public void executeByHql(String hql,Object[] params);
	public void executeByHql(String hql,Object param);
	public void executeByHql(String hql);
	
	

}
