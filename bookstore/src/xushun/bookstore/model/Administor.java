package xushun.bookstore.model;


/**
 * ����Ա��Ϣ
 * @author xushun
 *
 */
public class Administor implements java.io.Serializable {

	// Fields

	/** ����ԱId */
	private Integer adminId;
	
	/** ��¼�� */
	private String loginName;
	
	/** ���� */
	private String trueName;
	
	/** ���� */
	private String password;
	
	/** ����ʱ�� */
	private Long createTime;
	
	/** ����޸�ʱ�� */
	private Long lastModifyTime;

	// Constructors

	/** default constructor */
	public Administor() {
	}

	/** minimal constructor */
	public Administor(String loginName, String password, Long createTime,
			Long lastModifyTime) {
		this.loginName = loginName;
		this.password = password;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	/** full constructor */
	public Administor(String loginName, String trueName, String password,
			Long createTime, Long lastModifyTime) {
		this.loginName = loginName;
		this.trueName = trueName;
		this.password = password;
		this.createTime = createTime;
		this.lastModifyTime = lastModifyTime;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(Long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}