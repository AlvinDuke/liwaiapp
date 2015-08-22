package top.duyt.service.impl;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IDepDocDao;
import top.duyt.domain.DepDoc;
import top.duyt.service.IDepDocService;
import top.duyt.util.Pager;
import top.duyt.util.SystemContext;

@Service("depDocService")
@Scope("singleton")
public class DepDocService implements IDepDocService {
	
	@Resource
	private IDepDocDao depDocDao;

	public Pager<DepDoc> findSendDocByDepId(int depId,String param) {
		String hql = "select dd from DepDoc dd where dd.doc.user.department.id = ? "
				+ "and (dd.doc.title like '%" + param + "%' or dd.doc.content like '%" + param + "%') "
						+ "and dd.doc.user.id = ?";
		
		return depDocDao.find(hql, new Object[]{depId,SystemContext.getLoginUser().getId()});
	}

}
