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
 * ����Ա������һ���ֶ���
 * @author hp
 *
 */
@SuppressWarnings("serial")
public class AdministorAction extends BaseAction {
	
	private String loginName ;     /** ��¼�� */  
	private String password;       /** ���� */
	private String newPassword;    /** ������ */
	private String repassword;     /** ȷ������ */
	
	private int adminId;           /** ����ԱId */
	private Administor admin;      /** ����Ա */
	private DataPage<Administor> dataPageOfAdmin;    /** ����Ա��ҳ��Ϣ */
	private DataPage<Member> dataPageOfMember;       /** ��Ա��ҳ��Ϣ */  

	private String name;  /** ����������Ա�����Ա */
	
	
	/**
	 * ��ҳ�г���Ա��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String listMembers() throws Exception {
		dataPageOfMember = memberManager.selectDataPageMembers(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ͨ�������������з�����������Ļ�Ա��ҳ��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String listMembersByName() throws Exception {
		dataPageOfMember = memberManager.selectDataPageMembersByName(name, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ��ҳ�г�����Ա��Ϣ
	 * @return
	 * @throws Exception
	 */
	public String listAdmins() throws Exception {
		dataPageOfAdmin = adminManager.selectDataPageAdministors(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	/**
	 * ͨ�������������з�����������Ĺ���Ա��ҳ��Ϣ
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
	 * ����Ա��¼������¼�ɹ�����ѹ���Ա��������session����������
	 * @return ����true���������Ӧ�Ĺ���Ա����
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
	 * �޸Ĺ���Ա����
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
	 * ��ӹ���Ա
	 * @return
	 * @throws Exception
	 */
	public String addAdmin() throws Exception {
		if(StringUtil.isNull(admin.getLoginName()) || StringUtil.isNull(getPassword())) {
			return INPUT;
		}
		
		if(!getPassword().equals(getRepassword())) {
			addActionError("�����������벻ƥ��");
			return INPUT;
		}
		
		admin.setPassword(getPassword());
		admin.setCreateTime(System.currentTimeMillis());
		admin.setLastModifyTime(System.currentTimeMillis());
		adminManager.addAdministor(admin);
		
		return SUCCESS;
	}

	/**
	 * ɾ������Ա���첽
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
