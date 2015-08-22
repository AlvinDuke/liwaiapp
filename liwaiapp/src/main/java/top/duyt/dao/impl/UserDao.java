package top.duyt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import top.duyt.dao.IUserDao;
import top.duyt.domain.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao{

	public User findUserByUserName(String username) {
		return (User) queryByHql("from User u where u.username = ?", username);
	}

	@SuppressWarnings("unchecked")
	public List<User> listByIds(Integer[] uids) {
		Query q = this.getSession().createQuery("from User u where u.id in (:ids)");
		q.setParameterList("ids", uids);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<User> listRecsByCurUidOriSql(int Uid) {
		String sql = "select tut.id,tut.nickname from t_user tu left join dep_scope ds on "
				+ "tu.dep_id = ds.o_id right join t_user tut on "
				+ "ds.s_id = tut.dep_id "
				+ "where tu.id = ? ";
		return this.getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(User.class)).setParameter(0, Uid).list();
	}

}
