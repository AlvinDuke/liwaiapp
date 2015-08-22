package top.duyt.service;

import java.util.List;

import top.duyt.domain.DepScope;

public interface IDepScopeService {
	
	/**
	 * ���ڶ������һ�����ż��շ���ϵ
	 * @param deps
	 * @return
	 */
	public int addDepScope(DepScope deps);
	
	/**
	 * ���ڷ��Ͳ���ID�ͽ��ղ���ID����һ�����ż��շ���ϵ
	 * @param depid ���Ͳ���
	 * @param scpDepId ���ղ���
	 * @return
	 */
	public int addDepScope(int depid,int scpDepId);
	
	/**
	 * ���ڷ��Ͳ���ID�ͽ��ղ���ID����һ�鲿�ż��շ���ϵ
	 * @param depid ���Ͳ���
	 * @param scpDepIds һ����ղ���
	 * @return ��Ч����
	 */
	public int addDepScope(int depid,int[] scpDepIds);
	
	/**
	 * ����ָ�����Ͳ��ŵĽ��ղ��ţ��������µĽ��ղ���ID�����ղ����Ѵ��ڵĻᱣ���������ڵĻ�ɾ��
	 * @param depid ���Ͳ���
	 * @param scpDepIds һ����ղ���
	 * @return
	 */
	public int updateDepScope(int depid,int[] scpDepIds);
	
	/**
	 * ָ��һ�����Ͳ��ţ�����÷��Ͳ��ź������н��ղ��ż���շ���ϵ
	 * @param depid ���Ͳ���ID
	 */
	public void deleteReceiveDepScope(int depid);
	
	/**
	 * ָ��һ�����ղ��ţ�����ý��ղ��ź����в��ŵ��շ���ϵ
	 * @param scpDepId ����id
	 */
	public void deleteDepInDepScope(int scpDepId);
	
	
	/**
	 * ɾ��һ��ָ�����շ����Ź�ϵ
	 * @param depid ���Ͳ���
	 * @param scpDepId ���ղ���
	 */
	public void deleteDepScope(int depid,int scpDepId);
	
	/**
	 * �б��ż����е��շ���ϵ
	 * @return
	 */
	public List<DepScope> list();
	
	/**
	 * �б��ָ�����ź��������ż���շ���ϵ
	 * @param depId ָ������ID
	 * @return
	 */
	public List<DepScope> list(int depId);
	

}
