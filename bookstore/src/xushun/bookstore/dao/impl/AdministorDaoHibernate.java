package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.Administor;
import xushun.bookstore.util.DataPage;

public class AdministorDaoHibernate extends HibernateGenericDao<Administor>{
	@Override
	public void removeById(Serializable id) {
		// 删除管理员
		String hql = "delete from Administor admin where admin.adminId = :adminId";
		Query query = getSession().createQuery(hql);
		query.setInteger("adminId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * 通过登录名取得管理员
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
	 * 通过登录名和密码取得管理员
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
	 * 修改管理员密码
	 * @param adminId  管理员ID
	 * @param newPassword 新密码
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
	 * 判断登录名是否存在
	 * @param loginName 登录名
	 * @return true 如果存在，否则返回 false
	 */
	public boolean isLoginNameExits(String loginName) {
		Administor admin = getAdministorByLoginName(loginName);
		
		if(admin == null)
			return false;
		
		return true;
	}
	
	/**
	 * 获取管理员总数
	 * @return
	 */
	public int getNumberOfAdministors() {
		String hql = "select count(*) from Administor";
		Query query = getSession().createQuery(hql);
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Administor> selectDataPageAdministors(Integer pageNo,Integer pageSize) {
		String hql = "from Administor ";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Administor> selectDataPageAdministorsByName(String name,Integer pageNo,Integer pageSize) {
		String hql = "from Administor admin where admin.loginName like ? ";
		return pagedQuery(hql, pageNo, pageSize,"%"+name+"%");
	}
	
	
}
