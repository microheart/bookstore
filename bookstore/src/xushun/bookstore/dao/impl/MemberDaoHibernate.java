package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.Member;
import xushun.bookstore.util.DataPage;

public class MemberDaoHibernate extends HibernateGenericDao<Member> {

	@Override
	public void removeById(Serializable id) {
		// ɾ����Ա
		String hql = "delete from Member m where m.memberId = :memberId";
		Query query = getSession().createQuery(hql);
		query.setInteger("memberId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * ͨ����¼��ȡ�û�Ա
	 * @param loginName
	 * @return
	 */
	public Member getMemberByLoginName(String loginName) {
		String hql = "from Member m where m.loginName = :loginName";
		Query query = getSession().createQuery(hql);
		query.setString("loginName", loginName);
		return (Member)query.uniqueResult();
	}
	
	/**
	 * ͨ����¼��������ȡ�û�Ա
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Member getMemberByLoginNameAndPassword(String loginName,String password) {
		String hql = "from Member m where m.loginName = :loginName and m.password = :password";
		Query query = getSession().createQuery(hql);
		query.setString("loginName", loginName);
		query.setString("password", password);
		return (Member)query.uniqueResult();
	}
	
	/**
	 * �޸Ļ�Ա����
	 * @param memberId  ��ԱID
	 * @param newPassword ������
	 */
	public void updateMemberPassword(Integer memberId,String newPassword) {
		String hql = "update Member m set m.password = :newPassword m.lastModifyTime = :lastModifyTime where m.memberId = :memberId";
		Query query = getSession().createQuery(hql);
		query.setInteger("memberId", memberId);
		query.setString("password", newPassword);
		query.setLong("lastModifyTime", System.currentTimeMillis());
		query.executeUpdate();
	}
	
	/**
	 * �жϵ�¼���Ƿ����
	 * @param loginName ��¼��
	 * @return true ������ڣ����򷵻� false
	 */
	public boolean isLoginNameExits(String loginName) {
		Member member = getMemberByLoginName(loginName);
		
		if(member == null)
			return false;
		
		return true;
	}
	
	/**
	 * ��ȡ��Ա����
	 * @return
	 */
	public int getNumberOfMembers() {
		String hql = "select count(*) from Member";
		Query query = getSession().createQuery(hql);
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Member> selectDataPageMembers(Integer pageNo,Integer pageSize) {
		String hql = "from Member ";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Member> selectDataPageMembersByName(String name,Integer pageNo,Integer pageSize) {
		// hql��䲻��д�� from Member member where member.loginName like ?
		String hql = "from Member m where m.loginName like ?";
		return pagedQuery(hql, pageNo, pageSize, "%"+name+"%");
	}
	
	
}
