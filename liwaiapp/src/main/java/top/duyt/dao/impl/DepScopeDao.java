package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IDepScopeDao;
import top.duyt.domain.DepScope;

@Repository("depScopeDao")
public class DepScopeDao extends BaseDao<DepScope> implements IDepScopeDao{

}
