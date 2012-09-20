package xushun.bookstore.interceptor;

import java.util.Map;

import xushun.bookstore.model.Member;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ��ԱȨ������������Ҫ�û���¼
 * @author xushun
 *
 */
public class MemberAuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map session = context.getSession();
		
		Member member = (Member)session.get("member");
		
		if(member == null)
			return "member_login";
		
		return invocation.invoke();
	}

}
