package top.duyt.service;

import java.util.List;

import top.duyt.domain.User;
import top.duyt.util.Pager;

public interface IUserService {
	
	/**
	 * �����û�����
	 * @param user �û�����
	 * @param depId �û�����ID
	 * @return
	 */
	public int add(User user,int depId);
	
	/**
	 * ɾ���û�
	 * @param uid
	 */
	public void delete(int uid);
	
	/**
	 * �����û�ID
	 * @param user
	 * @param depId
	 */
	public void update(User user,int depId);
	
	/**
	 * �����û�
	 * @param uid
	 * @return
	 */
	public User load(int uid);
	
	/**
	 * ���ݲ��Ų����û�
	 * @param depId ����id
	 * @return
	 */
	public Pager<User> findByDepId(int depId);
		
	/**
	 * ����ָ�����û�Id��ѯ���û����������еĿɷ����û�
	 * @param curUid ָ���û���ID
	 * @return
	 */
	public List<User> listReceiversByCurUid(int curUid);
	
	/**
	 * ʹ��ԭ����
	 * @param curUid ָ�����û�ID
	 * @return
	 */
	public List<User> listRecsByCurUidOriSql(int curUid);
	
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);

}
