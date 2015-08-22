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
	//当前选择的可发件部门ID
	private int[] curSelDepScopes;
	
	@Resource
	private IDepartmentService departmentService;
	@Resource
	private IDepScopeService depScopeService;

	/**
	 * 部门列表
	 * 
	 * @return
	 */
	public String list() {
		ActionContext.getContext().put("ds", departmentService.list());
		ActionContext.getContext().put("url", "list");
		return SUCCESS;
	}

	/**
	 * 新增方法中间跳转
	 * 
	 * @return
	 */
	public String addInput() {
		// 所有部门
		departments = departmentService.list();
		ActionContext.getContext().put("url", "addInput");
		return SUCCESS;
	}

	/**
	 * 保存部门
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
	 * 部门新增前的校验
	 */
	public void validateAdd() {
		if (ActionUtil.isEmpty(department.getName())) {
			this.addFieldError("name", "部门名称不能为空");
			ActionContext.getContext().put("url", "addInput");
		} else {
			Department tempDep = departmentService.load(department.getName());
			if (tempDep != null) {
				this.addFieldError("name", "该部门已存在");
				ActionContext.getContext().put("url", "addInput");
			}
		}
	}

	/**
	 * 更新部门
	 * 
	 * @return
	 */
	public String update() {
		departmentService.updateDepartment(department);
		int count = depScopeService.updateDepScope(department.getId(), curSelDepScopes);
		
		//操作全部成功
		if (count == curSelDepScopes.length) {
			ActionContext.getContext().put("url", "dep_list");
			return ActionUtil.REDIRECT;
		}
		else{
			//有问题就返回录入页面
			this.addFieldError("name", "添加出现问题，请重新添加");
			ActionContext.getContext().put("url", "updateInput");
			return ActionUtil.REDIRECT;
		}
		
		
	}

	/**
	 * 更新中间跳转
	 * 
	 * @return
	 */
	public String updateInput() {
		department = departmentService.load(department.getId());
		// 所有部门
		departments = departmentService.list();
		// 目前已设置的发件部门
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
	 * 更新前校验
	 */
	public void validateUpdateInput() {
		department = departmentService.load(department.getId());
		if (department == null) {
			this.addFieldError("name", "该部门不存在");
			ActionContext.getContext().put("url", "list");
		}
	}

	/**
	 * 部门详情展示
	 * 
	 * @return
	 */
	public String show() {
		// 部门
		department = departmentService.load(department.getId());
		// 目前已设置的发件部门
		depScopes = depScopeService.list(department.getId());
		ActionContext.getContext().put("url", "show");

		return SUCCESS;
	}

	/**
	 * 查看前校验
	 * 
	 * @return
	 */
	public String validateShow() {
		if (department.getId() <= 0) {
			this.addFieldError("name", "该部门不存在");
			ActionContext.getContext().put("url", "list");
		} else {
			Department tempDep = departmentService.load(department.getId());
			if (tempDep == null) {
				this.addFieldError("name", "该部门不存在");
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
