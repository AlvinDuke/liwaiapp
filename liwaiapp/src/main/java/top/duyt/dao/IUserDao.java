package top.duyt.dao;

import java.util.List;

import top.duyt.domain.User;

public interface IUserDao extends IBaseDao<User> {
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUserName(String username);
	
	/**
	 * 通过一组用户ID获取一组用户对象
	 * @param uids
	 * @return
	 */
	public List<User> listByIds(Integer[] uids);
	
	/**
	 * 查找指定用户的可收信息人
	 * @param Uid
	 * @return
	 */
	public List<User> listRecsByCurUidOriSql(int Uid);
	
}
