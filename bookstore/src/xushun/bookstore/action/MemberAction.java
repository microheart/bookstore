package xushun.bookstore.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import xushun.bookstore.model.Member;
import xushun.bookstore.service.MemberManager;
import xushun.bookstore.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;

/**
 * 会员操作
 * @author xushun
 *
 */
public class MemberAction extends BaseAction {
	
	private int memberId;
	private String loginName;
	private String password;
	private String newPassword;
	private String repassword;
	
	private Member member;
	
	public String home() throws Exception {
		return SUCCESS;
	}

	public String toRegister() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 会员注册
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String register() throws Exception {
		if(StringUtil.isNull(member.getLoginName()) || StringUtil.isNull(member.getPassword()) || StringUtil.isNull(member.getGender()))
			return INPUT;
		
		if(memberManager.isLoginNameExists(member.getLoginName())) {
			addActionError("用户名已经被注册了，请您再换一个");
			return INPUT;
		}
		
		// 两次输入的密码必须一致
		if(member.getPassword().equals(repassword)) {
			member.setAmount(0.0);
			member.setLastModifyTime(System.currentTimeMillis());
			member.setRegisterTime(System.currentTimeMillis());
			member.setStatus(Member.MEMBER_STATUS_ACTIVITY);
			
			memberManager.addMember(member);
			
			Map session = ActionContext.getContext().getSession();
			session.put("member", member);
			
			return SUCCESS;
		}
		else {
			addActionError("密码必须一致");
		}
		

			
		return INPUT;
	}
	
	public String toEditInfo() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 编辑个人信息，不包括密码
	 * @return
	 * @throws Exception
	 */
	public String editInfo() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Member m = (Member)session.get("member");
		
		m.setAddress(member.getAddress());
		m.setEmail(member.getEmail());
		m.setGender(member.getGender());
		m.setLastModifyTime(System.currentTimeMillis());
		m.setPostcode(member.getPostcode());
		m.setTel(member.getTel());
		m.setTrueName(member.getTrueName());
		
		memberManager.updateMember(m);
		
		return SUCCESS;
	}
	
	public String toLogin() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 登录
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String login() throws Exception {
		member = memberManager.getMemberByLoginNameAndPassword(loginName, password);
		
		if(member == null)
			return INPUT;
		ActionContext context = ActionContext.getContext();
		context.getSession().put("member", member);
		
		return SUCCESS;
	}
	
	/**
	 * 退出登录
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		
		return SUCCESS;
	}
	
	public String toModifyPassword() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws Exception
	 */
	public String modifyPassword() throws Exception {
		if(StringUtil.isNull(getPassword()) || StringUtil.isNull(getNewPassword()))
			return INPUT;
		
		Map session = ActionContext.getContext().getSession();
		member = (Member)session.get("member");
		
		if(member.getPassword().equals(getPassword()) && getNewPassword().equals(getRepassword())) {
			member.setPassword(getNewPassword());
			memberManager.updateMember(member);
			//memberManager.modifyPassword(member.getMemberId(), getPassword(), getNewPassword());
			session.put("member", member);
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public String deleteMember() throws Exception {
		memberManager.removeMember(memberId);
		
		return SUCCESS;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


	
	
}
