package top.duyt.service;

import java.util.List;

import top.duyt.domain.Department;

public interface IDepartmentService {
	/**
	 * ����һ������
	 * @param dep
	 * @return
	 */
	public int addDepartment(Department dep);
	
	/**
	 * ɾ��һ������
	 * @param id
	 */
	public void deleteDepartment(int id);
	
	/**
	 * ���²�����Ϣ
	 * @param dep
	 */
	public void updateDepartment(Department dep);
	
	/**
	 * �б����еĲ���
	 * @return
	 */
	public List<Department> list();
	
	/**
	 * ����ID��ȡ����
	 * @param id
	 * @return
	 */
	public Department load(int id);
	
	/**
	 * ����ָ��������ѯһ�����Ŷ���
	 * @param hql
	 * @param params
	 * @return
	 */
	public Department load(String name);

}
