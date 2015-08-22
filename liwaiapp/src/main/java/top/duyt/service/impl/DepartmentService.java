package top.duyt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import top.duyt.dao.IDepartmentDao;
import top.duyt.domain.Department;
import top.duyt.service.IDepartmentService;

@Service("departmentService")
@Scope("singleton")
public class DepartmentService implements IDepartmentService {

	@Resource
	private IDepartmentDao departmentDao;

	public int addDepartment(Department dep) {
		return departmentDao.add(dep);
	}

	public void deleteDepartment(int id) {
		//TODO 删除依赖部门间的关系
	}

	public void updateDepartment(Department dep) {
		departmentDao.update(dep);
	}

	public List<Department> list() {
		return departmentDao.list("from Department");
	}

	public Department load(int id) {
		return departmentDao.load(id);
	}

	public Department load(String name) {
		
		Object obj = departmentDao.queryByHql("from Department dep where dep.name = ?", name);
		
		if (obj != null) {
			Department tempDep = (Department) obj;
			return tempDep;
		}
		
		return null;
	}

}
