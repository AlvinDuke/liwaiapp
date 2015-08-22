package top.duyt.service;

import java.util.List;

import top.duyt.domain.Department;

public interface IDepartmentService {
	/**
	 * 新增一个部门
	 * @param dep
	 * @return
	 */
	public int addDepartment(Department dep);
	
	/**
	 * 删除一个部门
	 * @param id
	 */
	public void deleteDepartment(int id);
	
	/**
	 * 更新部门信息
	 * @param dep
	 */
	public void updateDepartment(Department dep);
	
	/**
	 * 列表所有的部门
	 * @return
	 */
	public List<Department> list();
	
	/**
	 * 根据ID获取部门
	 * @param id
	 * @return
	 */
	public Department load(int id);
	
	/**
	 * 根据指定条件查询一个部门对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Department load(String name);

}
