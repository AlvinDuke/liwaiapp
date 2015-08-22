package top.duyt.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import top.duyt.domain.User;
import top.duyt.service.IUserService;
import top.duyt.util.ActionUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2242150814477517230L;

	@Resource
	private IUserService userService;

	private User user;

	/**
	 * ÓÃ»§µÇÂ¼
	 * 
	 * @return
	 */
	public String login() {
		User tempUser = userService.login(user.getUsername(),
				user.getPassword());
		if (tempUser != null) {
			ActionContext.getContext().getSession().put("loginUser", tempUser);
			ActionContext.getContext().put("url", "/user/user_list");
		} else {
			ActionContext.getContext().put("url", "user_loginInput");
		}
		return ActionUtil.REDIRECT;
	}

	/**
	 * ÍË³öµÇÂ¼
	 * @return
	 */
	public String logout() {
		ActionContext.getContext().getSession().clear();
		ActionContext.getContext().put("url", "/");
		return ActionUtil.REDIRECT;
	}

	/**
	 * µÇÂ½Ò³ÃæÌø×ª
	 * 
	 * @return
	 */
	public String loginInput() {
		return "login";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
