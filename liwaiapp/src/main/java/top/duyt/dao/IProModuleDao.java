package top.duyt.dao;

import java.util.List;

import top.duyt.domain.ProductModule;
import top.duyt.domain.ProductModuleExtention;

public interface IProModuleDao extends IBaseDao<ProductModule> {
	
	public List<ProductModuleExtention> listProductModuleExtentionByPid(int pid);
	
}
