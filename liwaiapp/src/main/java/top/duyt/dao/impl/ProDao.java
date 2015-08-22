package top.duyt.dao.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import top.duyt.dao.IProDao;
import top.duyt.domain.Product;

@Repository("proDao")
@Scope("singleton")
public class ProDao extends BaseDao<Product> implements IProDao{

}
