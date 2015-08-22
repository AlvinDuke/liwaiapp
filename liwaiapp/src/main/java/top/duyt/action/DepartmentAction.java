package top.duyt.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.DepScope;
import top.duyt.domain.Department;
import top.duyt.service.IDepScopeService;
import top.duyt.service.IDepartmentService;
import top.duyt.util.ActionUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements
		ModelDriven<Department> {
	private static final long serialVersionUID = 6780417278345912074L;

	private Department department;
	private List<DepScope> depScopes;
	private List<Department> departments;
	//��ǰѡ��Ŀɷ�������ID
	private int[] curSelDepScopes;
	
	@Resource
	private IDepartmentService departmentService;
	@Resource
	private IDepScopeService depScopeService;

	/**
	 * �����б�
	 * 
	 * @return
	 */
	public String list() {
		ActionContext.getContext().put("ds", departmentService.list());
		ActionContext.getContext().put("url", "list");
		return SUCCESS;
	}

	/**
	 * ���������м���ת
	 * 
	 * @return
	 */
	public String addInput() {
		// ���в���
		departments = departmentService.list();
		ActionContext.getContext().put("url", "addInput");
		return SUCCESS;
	}

	/**
	 * ���沿��
	 * 
	 * @return
	 */
	public String add() {
		departmentService.addDepartment(department);
		depScopeService.addDepScope(department.getId(), curSelDepScopes);
		ActionContext.getContext().put("url", "dep_list");
		return ActionUtil.REDIRECT;
	}

	/**
	 * ��������ǰ��У��
	 */
	public void validateAdd() {
		if (ActionUtil.isEmpty(department.getName())) {
			this.addFieldError("name", "�������Ʋ���Ϊ��");
			ActionContext.getContext().put("url", "addInput");
		} else {
			Department tempDep = departmentService.load(department.getName());
			if (tempDep != null) {
				this.addFieldError("name", "�ò����Ѵ���");
				ActionContext.getContext().put("url", "addInput");
			}
		}
	}

	/**
	 * ���²���
	 * 
	 * @return
	 */
	public String update() {
		departmentService.updateDepartment(department);
		int count = depScopeService.updateDepScope(department.getId(), curSelDepScopes);
		
		//����ȫ���ɹ�
		if (count == curSelDepScopes.length) {
			ActionContext.getContext().put("url", "dep_list");
			return ActionUtil.REDIRECT;
		}
		else{
			//������ͷ���¼��ҳ��
			this.addFieldError("name", "��ӳ������⣬���������");
			ActionContext.getContext().put("url", "updateInput");
			return ActionUtil.REDIRECT;
		}
		
		
	}

	/**
	 * �����м���ת
	 * 
	 * @return
	 */
	public String updateInput() {
		department = departmentService.load(department.getId());
		// ���в���
		departments = departmentService.list();
		// Ŀǰ�����õķ�������
		depScopes = depScopeService.list(department.getId());
		List<Integer> selectedDepScopes = new ArrayList<Integer>();
		for (DepScope ds : depScopes) {
			selectedDepScopes.add(ds.getScopeDep().getId());
		}
		
		ActionContext.getContext().put("url", "updateInput");
		ActionContext.getContext().put("selectedDepScopes", selectedDepScopes);
		
		return SUCCESS;
	}

	/**
	 * ����ǰУ��
	 */
	public void validateUpdateInput() {
		department = departmentService.load(department.getId());
		if (department == null) {
			this.addFieldError("name", "�ò��Ų�����");
			ActionContext.getContext().put("url", "list");
		}
	}

	/**
	 * ��������չʾ
	 * 
	 * @return
	 */
	public String show() {
		// ����
		department = departmentService.load(department.getId());
		// Ŀǰ�����õķ�������
		depScopes = depScopeService.list(department.getId());
		ActionContext.getContext().put("url", "show");

		return SUCCESS;
	}

	/**
	 * �鿴ǰУ��
	 * 
	 * @return
	 */
	public String validateShow() {
		if (department.getId() <= 0) {
			this.addFieldError("name", "�ò��Ų�����");
			ActionContext.getContext().put("url", "list");
		} else {
			Department tempDep = departmentService.load(department.getId());
			if (tempDep == null) {
				this.addFieldError("name", "�ò��Ų�����");
				ActionContext.getContext().put("url", "list");
			}
		}
		return SUCCESS;
	}

	public Department getModel() {
		if (department == null) {
			department = new Department();
		}
		return department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<DepScope> getDepScopes() {
		return depScopes;
	}

	public void setDepScopes(List<DepScope> depScopes) {
		this.depScopes = depScopes;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public int[] getCurSelDepScopes() {
		return curSelDepScopes;
	}

	public void setCurSelDepScopes(int[] curSelDepScopes) {
		this.curSelDepScopes = curSelDepScopes;
	}


}
