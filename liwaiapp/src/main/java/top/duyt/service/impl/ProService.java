package top.duyt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IProDao;
import top.duyt.dao.IProModuleDao;
import top.duyt.domain.Product;
import top.duyt.domain.ProductModuleExtention;
import top.duyt.dto.ProInfoDto;
import top.duyt.service.IProService;

@Service("proService")
@Scope("singleton")
public class ProService implements IProService{
	
	@Resource
	private IProDao proDao;
	@Resource
	private IProModuleDao proModuleDao;
	
	public int add(Product p) {
		return proDao.add(p);
	}
	public void delete(int pid) {
		proDao.delete(pid);
	}
	public void update(Product p) {
		proDao.update(p);
	}
	public Product load(int pid) {
		return proDao.load(pid);
	}
	public Product get(int pid) {
		return proDao.get(pid);
	}
	public ProInfoDto loadProInfo(int pid) {
		
		Product p = proDao.load(pid);
		List<ProductModuleExtention> moduleExtentions = proModuleDao.listProductModuleExtentionByPid(pid);

		ProInfoDto dto = new ProInfoDto();
		dto.setPro(p);
		dto.setModuleExtentions(moduleExtentions);
		
		return dto;
	}

}
