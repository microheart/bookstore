package xushun.bookstore.action;

import java.util.Map;

import xushun.bookstore.model.Administor;
import xushun.bookstore.model.Member;
import xushun.bookstore.service.AdministorManager;
import xushun.bookstore.service.MemberManager;
import xushun.bookstore.util.DataPage;
import xushun.bookstore.util.StringUtil;

import com.opensymphony.xwork2.ActionContext;

/**
 * 管理员操作的一部分动作
 * @author hp
 *
 */
@SuppressWarnings("serial")
public class AdministorAction extends BaseAction {
	
	private String loginName ;     /** 登录名 */  
	private String password;       /** 密码 */
	private String newPassword;    /** 新密码 */
	private String repassword;     /** 确认密码 */
	
	private int adminId;           /** 管理员Id */
	private Administor admin;      /** 管理员 */
	private DataPage<Administor> dataPageOfAdmin;    /** 管理员分页信息 */
	private DataPage<Member> dataPageOfMember;       /** 会员分页信息 */  

	private String name;  /** 用于搜索会员或管理员 */
	
	
	/**
	 * 分页列出会员信息
	 * @return
	 * @throws Exception
	 */
	public String listMembers() throws Exception {
		dataPageOfMember = memberManager.selectDataPageMembers(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 通过名字搜索所有符合名字情况的会员分页信息
	 * @return
	 * @throws Exception
	 */
	public String listMembersByName() throws Exception {
		dataPageOfMember = memberManager.selectDataPageMembersByName(name, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 分页列出管理员信息
	 * @return
	 * @throws Exception
	 */
	public String listAdmins() throws Exception {
		dataPageOfAdmin = adminManager.selectDataPageAdministors(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * 通过名字搜索所有符合名字情况的管理员分页信息
	 * @return
	 * @throws Exception
	 */
	public String listAdminsByName() throws Exception {
		dataPageOfAdmin = adminManager.selectDataPageAdministorsByName(name, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	public String toLogin() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 管理员登录，若登录成功，则把管理员对象存放在session作用域里面
	 * @return 返回true如果存在相应的管理员对象
	 * @throws Exception
	 */
	public String login() throws Exception {
		admin = adminManager.getAdministorByLoginNameAndPassword(loginName, password);
		
		if(admin == null)
			return INPUT;
		
		Map session = ActionContext.getContext().getSession();
		session.put("administor", admin);
		
		return SUCCESS;
	}
	
	
	public String toModifyPassword() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 修改管理员密码
	 * @return
	 * @throws Exception
	 */
	public String modifyPassword() throws Exception {
		if(StringUtil.isNull(getPassword()) || StringUtil.isNull(getNewPassword()))
			return INPUT;

		Map session = ActionContext.getContext().getSession();
		admin = (Administor)session.get("administor");
		
		if(admin.getPassword().equals(getPassword()) && getNewPassword().equals(getRepassword())) {
			admin.setPassword(getNewPassword());
			admin.setLastModifyTime(System.currentTimeMillis());
			adminManager.updateAdministor(admin);
			//memberManager.modifyPassword(member.getMemberId(), getPassword(), getNewPassword());
			session.put("administor", admin);
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public String toAddAdmin() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 添加管理员
	 * @return
	 * @throws Exception
	 */
	public String addAdmin() throws Exception {
		if(StringUtil.isNull(admin.getLoginName()) || StringUtil.isNull(getPassword())) {
			return INPUT;
		}
		
		if(!getPassword().equals(getRepassword())) {
			addActionError("两次输入密码不匹配");
			return INPUT;
		}
		
		admin.setPassword(getPassword());
		admin.setCreateTime(System.currentTimeMillis());
		admin.setLastModifyTime(System.currentTimeMillis());
		adminManager.addAdministor(admin);
		
		return SUCCESS;
	}

	/**
	 * 删除管理员，异步
	 * @return
	 * @throws Exception
	 */
	public String deleteAdmin() throws Exception {
		adminManager.removeAdministorById(adminId);
		
		return SUCCESS;
	}
	
	public Administor getAdmin() {
		return admin;
	}

	public void setAdmin(Administor admin) {
		this.admin = admin;
	}

	public DataPage<Member> getDataPageOfMember() {
		return dataPageOfMember;
	}

	public void setDataPageOfMember(DataPage<Member> dataPageOfMember) {
		this.dataPageOfMember = dataPageOfMember;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public DataPage<Administor> getDataPageOfAdmin() {
		return dataPageOfAdmin;
	}

	public void setDataPageOfAdmin(DataPage<Administor> dataPageOfAdmin) {
		this.dataPageOfAdmin = dataPageOfAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


}
