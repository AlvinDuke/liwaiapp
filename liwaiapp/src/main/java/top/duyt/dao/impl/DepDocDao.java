package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IDepDocDao;
import top.duyt.domain.DepDoc;

@Repository("depDocDao")
public class DepDocDao extends BaseDao<DepDoc> implements IDepDocDao{

}
