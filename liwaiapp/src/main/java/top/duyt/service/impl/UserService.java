package top.duyt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.Exception.DocumentException;
import top.duyt.dao.IDepartmentDao;
import top.duyt.dao.IUserDao;
import top.duyt.domain.Department;
import top.duyt.domain.User;
import top.duyt.service.IUserService;
import top.duyt.util.Pager;

@Service("userService")
@Scope("singleton")
public class UserService implements IUserService{
	
	@Resource
	private IUserDao userDao;
	@Resource
	private IDepartmentDao departmentDao;
	

	public int add(User user, int depId) {
		Department tempDep = departmentDao.load(depId);
		if (tempDep != null) {
			user.setDepartment(tempDep);
		}
		return userDao.add(user);
	}

	public void delete(int uid) {
		userDao.delete(uid);
	}

	public void update(User user, int depId) {
		Department tempDep = departmentDao.load(depId);
		if (tempDep != null) {
			user.setDepartment(tempDep);
		}
		userDao.update(user);
	}

	public Pager<User> findByDepId(int depId) {
		if (depId <= 0) {
			return userDao.find("from User u left join fetch u.department");
		}else{
			return userDao.find("from User u left join fetch u.department dep where dep.id = ?", depId);
		}
	}

	public User load(int uid) {
		return userDao.load(uid);
	}

	public User login(String username, String password){
		User user = userDao.findUserByUserName(username);
		//用户不存在
		if (user == null) {
			throw new DocumentException("用户不存在");
		}
		else{
			if (user.getPassword().equals(password)) {
				return user;
			}
			else {
				throw new DocumentException("用户名或密码不正确");
			}
		}
	}

	public List<User> listReceiversByCurUid(int curUid) {
		String hql = "select scopeU "
					+ "from User u,DepScope ds,User scopeU "
					+ "where u.department.id = ds.oriDepId and scopeU.department.id = ds.scopeDep.id and u.id = ?";
		return userDao.list(hql, curUid);
	}

	public List<User> listRecsByCurUidOriSql(int curUid) {
		return userDao.listRecsByCurUidOriSql(curUid);
	}

}
