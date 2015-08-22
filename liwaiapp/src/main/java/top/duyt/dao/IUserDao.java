package top.duyt.dao;

import java.util.List;

import top.duyt.domain.User;

public interface IUserDao extends IBaseDao<User> {
	
	/**
	 * �����û��������û�
	 * @param username
	 * @return
	 */
	public User findUserByUserName(String username);
	
	/**
	 * ͨ��һ���û�ID��ȡһ���û�����
	 * @param uids
	 * @return
	 */
	public List<User> listByIds(Integer[] uids);
	
	/**
	 * ����ָ���û��Ŀ�����Ϣ��
	 * @param Uid
	 * @return
	 */
	public List<User> listRecsByCurUidOriSql(int Uid);
	
}
