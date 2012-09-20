package xushun.bookstore.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;

public class FirstTypeDaoHibernate extends HibernateGenericDao<FirstType> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete FirstType ft where ft.typeId = :typeId";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * 更新分类名
	 * @param typeId
	 * @param typeName
	 */
	public void updateTypeName(Integer typeId, String typeName) {
		String hql = "update FirstType ft set ft.typeName = :typeName ft.lastModifyTime = :lastModifyTime where ft.typeId = :typeId";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", typeId);
		query.setString("typeName", typeName);
		query.setLong("lastModifyTime", System.currentTimeMillis());
		query.executeUpdate();
	}
	
	/**
	 * 获取一级分类并且取得它的子类别
	 * @param typeId 一级分类Id
	 * @return
	 */
	public FirstType getFirstTypeWithSubTypes(Integer typeId) {
		FirstType st = getById(typeId);
		
		st.setSubTypes(getSubTypes(typeId));
		
		return st;
	}
	
	/**
	 * 获取一级分类但不取得它的子类别列表
	 * @param typeId
	 * @return
	 */
	public FirstType getFirstTypeWithoutSubTypes(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * 取得所有一级分类，但不包括其子类别
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FirstType> getAllFirstTypesWithoutSubTypes() {
		String hql = "from FirstType";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * 获取一级分类但不取得它的子类别列表
	 * @param typeId
	 * @return
	 */
	public FirstType getFirstType(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * 判断一级分类名是否存在
	 * @param typeName
	 * @return 返回true如果存在，否则返回false
	 */
	@SuppressWarnings("unchecked")
	public boolean isTypeNameExists(String typeName) {
		String hql = "from FirstType ft where ft.typeName = :typeName";
		Query query = getSession().createQuery(hql);
		query.setString("typeName", typeName);
		List list = query.list();
		
		if((list == null) || (list.size() == 0))
			return false;
		
		return true;
	}
	
	/**
	 * 取得一级分类下面的子分类列表
	 * @param ftId 一级分类Id
	 * @return 子分类列表
	 */
	@SuppressWarnings("unchecked")
	public List<SecondType> getSubTypes(Integer ftId) {
		String hql = "from SecondType st where st.superId = :superId";
		Query query = getSession().createQuery(hql);
		query.setInteger("superId", ftId);
		return query.list();
	}
}
