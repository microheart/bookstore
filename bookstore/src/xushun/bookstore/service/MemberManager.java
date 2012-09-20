package xushun.bookstore.service;

import xushun.bookstore.model.Member;
import xushun.bookstore.util.DataPage;

/**
 * ��Ա����
 * @author xushun
 *
 */
public interface MemberManager {
	
	/**
	 * ��ӻ�Ա
	 * @param member
	 * @throws Exception
	 */
	public void addMember(Member member) throws Exception ;

	/**
	 * ���»�Ա����
	 * @param member
	 * @throws Exception
	 */
	public void updateMember(Member member) throws Exception ;
	
	/**
	 * ͨ����ԱIdɾ����Ա
	 * @param memberId
	 * @throws Exception
	 */
	public void removeMember(Integer memberId) throws Exception ;
	
	/**
	 * ���ݻ�ԱId��ѯ��Ա�����û���򷵻ؿ�
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public Member getMemberById(Integer memberId) throws Exception ;
	
	
	/**
	 * ͨ����¼����ѯ��Ա������������򷵻ؿ�
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public Member getMemberByLoginName(String loginName) throws Exception ;
	
	/**
	 * ͨ����¼��������ȡ�û�Ա
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Member getMemberByLoginNameAndPassword(String loginName,String password) ;
	
	/**
	 * �޸Ļ�Ա����.<br>
	 * <br>
	 * <font color="red">
	 * ���1����Ա�����������󣬷���false ;<br>
	 * ���2����Ա������ȷ���޸ĳɹ�������true;<br>
	 * ���3�����ڴ���Ļ�Ա��ʶ���󣬻������ݿ�����г������⣬�׳��쳣;<br>
	 * </font>
	 * @param memberId
	 * @param oldPassword
	 * @param newPassword
	 * @return boolean
	 * @throws Exception
	 */
	public boolean modifyPassword(Integer memberId, String oldPassword, String newPassword) throws Exception;
	
	/**
	 * �жϵ�¼���Ƿ����.<br>
	 * @param loginName
	 * @return boolean
	 * @throws Exception
	 */
	boolean isLoginNameExists(String loginName) throws Exception;
	
	/**
	 * ��Ա��ҳ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Member> selectDataPageMembers(Integer pageNo,Integer pageSize) throws Exception;
	
	/**
	 * ͨ�����ֲ��һ�Ա
	 * @param name
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Member> selectDataPageMembersByName(String name,Integer pageNo,Integer pageSize) throws Exception ;
}
