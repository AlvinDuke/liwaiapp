package top.duyt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IDepScopeDao;
import top.duyt.dao.IDepartmentDao;
import top.duyt.domain.DepScope;
import top.duyt.domain.Department;
import top.duyt.service.IDepScopeService;

@Service("depScopeService")
@Scope("singleton")
public class DepScopeService implements IDepScopeService{

	@Resource
	private IDepScopeDao depScopeDao;
	@Resource
	private IDepartmentDao departmentDao;
	
	public int addDepScope(DepScope deps) {
		
		//重复的收发关系不添加
		if ((depScopeDao.load(deps.getId())) == null) {
			return depScopeDao.add(deps);
		}else{
			return 0;
		}
		
	}

	public int addDepScope(int depid, int scpDepId) {
		
		Department scpd = departmentDao.load(scpDepId);
		//接收部门存在就添加该关系
		if (scpd != null) {
			//发送部门Id正确的情况下再添加
			if (depid > 0) {
				DepScope ds = new DepScope();
				ds.setOriDepId(depid);
				ds.setScopeDep(scpd);
				return depScopeDao.add(ds);
			}
		}
		return 0;
	}

	public int addDepScope(int depid, int[] scpDepIds) {
		
		int counter = 0;
		for (int i = 0; i < scpDepIds.length; i++) {
			//添加成功，生效行数+1
			if (this.addDepScope(depid,scpDepIds[i]) > 0) {
				counter++;
			}
		}
		return counter;
	}

	public void deleteReceiveDepScope(int depid) {
		String hql = "delete DepScope ds where ds.oriDepId = ? ";
		depScopeDao.executeByHql(hql, depid);		
	}

	public void deleteDepInDepScope(int scpDepId) {
		String hql = "delete DepScope ds where ds.scopeDep.id = ? ";
		depScopeDao.executeByHql(hql, scpDepId);	
	}

	public void deleteDepScope(int depid, int scpDepId) {
		String hql = "delete DepScope ds where ds.oriDepId = ? and ds.scopeDep.id = ? ";
		depScopeDao.executeByHql(hql, new Object[]{depid,scpDepId});
		
	}

	public List<DepScope> list() {
		return depScopeDao.list("from DepScope");
	}

	public List<DepScope> list(int depId) {
		return depScopeDao.list("from DepScope ds where ds.oriDepId = ?",depId);
	}

	public int updateDepScope(int depid, int[] scpDepIds) {
		this.deleteReceiveDepScope(depid);
		return this.addDepScope(depid, scpDepIds);
	}
	
}
