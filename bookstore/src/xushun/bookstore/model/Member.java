package xushun.bookstore.model;


/**
 * ��Ա��Ϣ
 * @author xushun
 *
 */
public class Member implements java.io.Serializable {

	// Fields
	public static final int MEMBER_STATUS_ACTIVITY = 1;
	public static final int MEMBER_STATUS_UNACTIVITY = 0;

	private Integer memberId;      // ��ԱId
	private String loginName;      // ��¼��
	private String trueName;       // ����
	private String password;       // ����
	private String gender;         // �Ա�
	private String address;        // ��ַ
	private String postcode;       // �ʱ�
	private String email;          // ����
	private String tel;            // �绰
	private Double amount;         // ���ѽ��
	private Integer status;        // ״̬
	private Long registerTime;     // ע��ʱ��
	private Long lastModifyTime;   // ����޸�ʱ��

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String loginName, String trueName, String password,
			String gender, Double amount, Integer status, Long registerTime,
			Long lastModifyTime) {
		this.loginName = loginName;
		this.trueName = trueName;
		this.password = password;
		this.gender = gender;
		this.amount = amount;
		this.status = status;
		this.registerTime = registerTime;
		this.lastModifyTime = lastModifyTime;
	}

	/** full constructor */
	public Member(String loginName, String trueName, String password,
			String gender, String address, String postcode, String email,
			String tel, Double amount, Integer status, Long registerTime,
			Long lastModifyTime) {
		this.loginName = loginName;
		this.trueName = trueName;
		this.password = password;
		this.gender = gender;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.tel = tel;
		this.amount = amount;
		this.status = status;
		this.registerTime = registerTime;
		this.lastModifyTime = lastModifyTime;
	}

	// Property accessors

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Long registerTime) {
		this.registerTime = registerTime;
	}

	public Long getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(Long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}