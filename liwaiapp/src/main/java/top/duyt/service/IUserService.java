package top.duyt.service;

import java.util.List;

import top.duyt.domain.User;
import top.duyt.util.Pager;

public interface IUserService {
	
	/**
	 * 新增用户对象
	 * @param user 用户对象
	 * @param depId 用户部门ID
	 * @return
	 */
	public int add(User user,int depId);
	
	/**
	 * 删除用户
	 * @param uid
	 */
	public void delete(int uid);
	
	/**
	 * 更新用户ID
	 * @param user
	 * @param depId
	 */
	public void update(User user,int depId);
	
	/**
	 * 查找用户
	 * @param uid
	 * @return
	 */
	public User load(int uid);
	
	/**
	 * 根据部门查找用户
	 * @param depId 部门id
	 * @return
	 */
	public Pager<User> findByDepId(int depId);
		
	/**
	 * 根据指定的用户Id查询该用户包含的所有的可发信用户
	 * @param curUid 指定用户的ID
	 * @return
	 */
	public List<User> listReceiversByCurUid(int curUid);
	
	/**
	 * 使用原生的
	 * @param curUid 指定的用户ID
	 * @return
	 */
	public List<User> listRecsByCurUidOriSql(int curUid);
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);

}
