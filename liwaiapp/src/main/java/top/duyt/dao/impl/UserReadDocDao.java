package top.duyt.dao.impl;


import org.springframework.stereotype.Repository;

import top.duyt.dao.IUserReadDocDao;
import top.duyt.domain.UserReadDoc;

@Repository("userReadDocDao")
public class UserReadDocDao extends BaseDao<UserReadDoc> implements IUserReadDocDao {

}
