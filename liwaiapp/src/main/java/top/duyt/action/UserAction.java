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
	//���ʱѡ��Ĳ���ID
	private int depBelongs;
	//�б�ʱѡ���ŵ�ID
	private int searchDep;
	@Resource
	private IUserService userService;
	@Resource
	private IDepartmentService departmentService;

	/**
	 * �����û�
	 * @return
	 */
	public String add(){
		userService.add(user, depBelongs);
		ActionContext.getContext().put("url", "user_list");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * �鿴�û�
	 * @return
	 */
	public String show(){
		user = userService.load(user.getId());
		ActionContext.getContext().put("url", "show");
		return SUCCESS;
	}
		
	/**
	 * У��
	 * @return
	 */
	public String update(){
		userService.update(user, depBelongs);
		ActionContext.getContext().put("url", "user_list");
		return ActionUtil.REDIRECT;
	}
	
	/**
	 * ����ǰУ��
	 */
	public void validateupdate(){
		if (ActionUtil.isEmpty(user.getNickname())) {
			this.addFieldError("nickname", "�ǳƲ���Ϊ��");
			ActionContext.getContext().put("url", "updateInput");
		}
		if (ActionUtil.isEmpty(user.getEmail())) {
			this.addFieldError("email", "���䲻��Ϊ��");
			ActionContext.getContext().put("url", "updateInput");
		}
	}
	
	/**
	 * ����ǰ��ת
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
	 * �����û�ǰУ��
	 * @return
	 */
//	public void validateAdd(){
//		if (ActionUtil.isEmpty(user.getUsername())) {
//			this.addFieldError("username", "�û�������Ϊ��");
//			ActionContext.getContext().put("url", "addInput");
//		}
//		if (ActionUtil.isEmpty(user.getNickname())) {
//			this.addFieldError("nickname", "�ǳƲ���Ϊ��");
//			ActionContext.getContext().put("url", "addInput");
//		}
//		if (ActionUtil.isEmpty(user.getEmail())) {
//			this.addFieldError("email", "���䲻��Ϊ��");
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
	 * �б�
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
