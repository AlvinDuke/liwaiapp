package top.duyt.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.Department;
import top.duyt.domain.User;
import top.duyt.service.IDepartmentService;
import top.duyt.service.IUserService;
import top.duyt.util.ActionUtil;
import top.duyt.util.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 2698940294947436354L;
	private User user;
	//添加时选择的部门ID
	private int depBelongs;
	//列表时选择部门的ID
	private int searchDep;
	@Resource
	private IUserService userService;
	@Resource
	private IDepartmentService departmentService;

	/**
	 * 新增用户
	 * @return
	 */
	public String add(){
		userService.add(user, depBelongs);
		ActionContext.getContext().put("url", "user_list");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 查看用户
	 * @return
	 */
	public String show(){
		user = userService.load(user.getId());
		ActionContext.getContext().put("url", "show");
		return SUCCESS;
	}
		
	/**
	 * 校验
	 * @return
	 */
	public String update(){
		userService.update(user, depBelongs);
		ActionContext.getContext().put("url", "user_list");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * 更新前校验
	 */
	public void validateupdate(){
		if (ActionUtil.isEmpty(user.getNickname())) {
			this.addFieldError("nickname", "昵称不可为空");
			ActionContext.getContext().put("url", "updateInput");
		}
		if (ActionUtil.isEmpty(user.getEmail())) {
			this.addFieldError("email", "邮箱不可为空");
			ActionContext.getContext().put("url", "updateInput");
		}
	}
	
	/**
	 * 更新前跳转
	 * @return
	 */
	public String updateInput(){
		user = userService.load(user.getId());
		List<Department> ds = departmentService.list();
		ActionContext.getContext().put("url", "updateInput");
		ActionContext.getContext().put("ds", ds);
		return SUCCESS;
	}
	
	/**
	 * 新增用户前校验
	 * @return
	 */
//	public void validateAdd(){
//		if (ActionUtil.isEmpty(user.getUsername())) {
//			this.addFieldError("username", "用户名不能为空");
//			ActionContext.getContext().put("url", "addInput");
//		}
//		if (ActionUtil.isEmpty(user.getNickname())) {
//			this.addFieldError("nickname", "昵称不能为空");
//			ActionContext.getContext().put("url", "addInput");
//		}
//		if (ActionUtil.isEmpty(user.getEmail())) {
//			this.addFieldError("email", "邮箱不能为空");
//			ActionContext.getContext().put("url", "addInput");
//		}
//	}
	
	/**
	 * 
	 * @return
	 */
	public String addInput(){
		List<Department> ds = departmentService.list();
		ActionContext.getContext().put("ds", ds);
		ActionContext.getContext().put("url", "addInput");
		return SUCCESS;
	}
	
	/**
	 * 列表
	 * @return
	 */
	public String list(){
		Pager<User> pager = userService.findByDepId(searchDep);
		List<Department> ds = departmentService.list();
		ActionContext.getContext().put("ds", ds);
		ActionContext.getContext().put("pager", pager);
		ActionContext.getContext().put("url", "list");
		return SUCCESS;
	}
	
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDepBelongs() {
		return depBelongs;
	}

	public void setDepBelongs(int depBelongs) {
		this.depBelongs = depBelongs;
	}

	public int getSearchDep() {
		return searchDep;
	}

	public void setSearchDep(int searchDep) {
		this.searchDep = searchDep;
	}

}
