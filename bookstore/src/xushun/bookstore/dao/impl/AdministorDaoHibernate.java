package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.Administor;
import xushun.bookstore.util.DataPage;

public class AdministorDaoHibernate extends HibernateGenericDao<Administor>{
	@Override
	public void removeById(Serializable id) {
		// ɾ������Ա
		String hql = "delete from Administor admin where admin.adminId = :adminId";
		Query query = getSession().createQuery(hql);
		query.setInteger("adminId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * ͨ����¼��ȡ�ù���Ա
	 * @param loginName
	 * @return
	 */
	public Administor getAdministorByLoginName(String loginName) {
		String hql = "from Administor admin where admin.loginName = :loginName";
		Query query = getSession().createQuery(hql);
		query.setString("loginName", loginName);
		return (Administor)query.uniqueResult();
	}
	
	/**
	 * ͨ����¼��������ȡ�ù���Ա
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Administor getAdministorByLoginNameAndPassword(String loginName,String password) {
		String hql = "from Administor admin where admin.loginName = :loginName and admin.password = :password";
		Query query = getSession().createQuery(hql);
		query.setString("loginName", loginName);
		query.setString("password", password);
		return (Administor)query.uniqueResult();
	}
	
	/**
	 * �޸Ĺ���Ա����
	 * @param adminId  ����ԱID
	 * @param newPassword ������
	 */
	public void updateAdministorPassword(Integer adminId,String newPassword) {
		String hql = "update Administor admin set admin.password = :newPassword admin.lastModifyTime = :lastModifyTime where admin.adminId = :adminId";
		Query query = getSession().createQuery(hql);
		query.setInteger("adminId", adminId);
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
		Administor admin = getAdministorByLoginName(loginName);
		
		if(admin == null)
			return false;
		
		return true;
	}
	
	/**
	 * ��ȡ����Ա����
	 * @return
	 */
	public int getNumberOfAdministors() {
		String hql = "select count(*) from Administor";
		Query query = getSession().createQuery(hql);
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Administor> selectDataPageAdministors(Integer pageNo,Integer pageSize) {
		String hql = "from Administor ";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Administor> selectDataPageAdministorsByName(String name,Integer pageNo,Integer pageSize) {
		String hql = "from Administor admin where admin.loginName like ? ";
		return pagedQuery(hql, pageNo, pageSize,"%"+name+"%");
	}
	
	
}
