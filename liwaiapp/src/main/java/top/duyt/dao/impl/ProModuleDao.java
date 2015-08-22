package top.duyt.dao.impl;


import java.util.List;

import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import top.duyt.dao.IProModuleDao;
import top.duyt.domain.ProductModule;
import top.duyt.domain.ProductModuleExtention;

@Repository("proModuleDao")
@Scope("singleton")
@SuppressWarnings("unchecked")
public class ProModuleDao extends BaseDao<ProductModule> implements IProModuleDao{

	public List<ProductModuleExtention> listProductModuleExtentionByPid(int pid) {
		String sql = "select pm.*,pmv1.conval as colourValue,pmv2.conval as sizeValue from t_pro_module pm left join t_pro_module_values pmv1 on pm.colourkey = pmv1.conkey left join t_pro_module_values pmv2 on pm.sizekey = pmv2.conkey where pid = ?";
		return this.getSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(ProductModuleExtention.class)).setParameter(0, pid).list();
	}

}
