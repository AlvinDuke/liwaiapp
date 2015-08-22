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
		
		//δ��¼�û���Ҫ�ȵ�¼
		if (loginUser == null) {
			return "login";
		}
		
		//����Ȩ�޿���
		String userType = loginUser.getType();
		
		//����Ա
		if ("1".equals(userType)) {
			//�Ƿ���Ȩ��
			if (!checkCurUrl("admin",invocation)) {
				return "noAuthority";
			}
		}else{
			//һ���û�
			if (!checkCurUrl("user",invocation)) {
				return "noAuthority";
			}
		}
		
		//�����ѵ�¼�û�
		SystemContext.setLoginUser(loginUser);
		
		invocation.getAction();
		
		//TODO ��ӿ�����Ҫ������Ȩ�޿���
		
		return invocation.invoke();
	}
	
	/**
	 * ���ָ���û����͵�����Ȩ���Ƿ��ܷ��ʵ�ǰ������
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
