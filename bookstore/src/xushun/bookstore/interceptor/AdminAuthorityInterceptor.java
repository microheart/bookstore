package xushun.bookstore.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import xushun.bookstore.model.Administor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 管理员权限拦截器
 * @author xushun
 *
 */
public class AdminAuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map session = context.getSession();
		
//		HttpServletRequest request= (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
//		System.out.println("url: " + request.getRequestURL());
//		System.out.println("queryString: " + request.getQueryString());
//		System.out.println("total: " + request.getRequestURL() + "?" + request.getQueryString());
		
		Administor admin = (Administor)session.get("administor");
		
		if(admin == null)
			return "admin_login";
		
		return invocation.invoke();
	}

}
