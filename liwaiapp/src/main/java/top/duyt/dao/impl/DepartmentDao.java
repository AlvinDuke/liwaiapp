package top.duyt.dao.impl;

import org.springframework.stereotype.Repository;

import top.duyt.dao.IDepartmentDao;
import top.duyt.domain.Department;

@Repository("departmentDao")
public class DepartmentDao extends BaseDao<Department> implements IDepartmentDao{

}
