package top.duyt.interceptor;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import top.duyt.domain.User;
import top.duyt.util.AuthPropertiesUtil;
import top.duyt.util.SystemContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component("authInterceptor")
public class AuthInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = -650455587754720491L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		User loginUser = (User) ActionContext.getContext().getSession().get("loginUser");
		
		//未登录用户需要先登录
		if (loginUser == null) {
			return "login";
		}
		
		//简易权限控制
		String userType = loginUser.getType();
		
		//管理员
		if ("1".equals(userType)) {
			//是否有权限
			if (!checkCurUrl("admin",invocation)) {
				return "noAuthority";
			}
		}else{
			//一般用户
			if (!checkCurUrl("user",invocation)) {
				return "noAuthority";
			}
		}
		
		//设置已登录用户
		SystemContext.setLoginUser(loginUser);
		
		invocation.getAction();
		
		//TODO 添加可能需要的其他权限控制
		
		return invocation.invoke();
	}
	
	/**
	 * 检查指定用户类型的所含权限是否能访问当前的链接
	 * @param userType
	 * @param invocation
	 * @return
	 * @throws IOException
	 */
	private boolean checkCurUrl(String userType,ActionInvocation invocation) throws IOException{
		List<String> authRecs = AuthPropertiesUtil.getAuth(userType);
		Boolean hasAuthOrNot = false;
		for (String authStr : authRecs) {
			if (invocation.getProxy().getActionName().toString().startsWith(authStr)) {
				hasAuthOrNot = true;
			}
		}
		return hasAuthOrNot;
	}

}
