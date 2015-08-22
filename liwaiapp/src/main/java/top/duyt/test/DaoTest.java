package top.duyt.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.duyt.dao.IDepScopeDao;
import top.duyt.dao.IDepartmentDao;
import top.duyt.dao.IDocumentDao;
import top.duyt.domain.DepScope;
import top.duyt.domain.Department;
import top.duyt.domain.Document;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DaoTest {
	
	@Resource
	private IDepartmentDao departmentDao;
	
	@Resource
	private IDepScopeDao depScopeDao;
	
	@Resource
	private IDocumentDao documentDao;
	
	@Test
	public void test01(){
		Department d = new Department();
		d.setName("行政部");
		departmentDao.add(d);
	}
	
	@Test
	public void test02(){
		DepScope ds = new DepScope();
		ds.setOriDepId(1);
		ds.setScopeDep(departmentDao.load(1));
		depScopeDao.add(ds);
	}
	
	@Test
	public void test03(){
		Document d = new Document();
		d.setTitle("测试用标题");
		d.setContent("测试用的内容");
		d.setCredate(new Date());
		documentDao.add(d);
	}
	
	@Test
	public void test04(){
		Department dep = departmentDao.load(1);
		System.out.println(dep.toString());
	}
	
	

}
