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
	 * ���·�����
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
	 * ��ȡһ�����ಢ��ȡ�����������
	 * @param typeId һ������Id
	 * @return
	 */
	public FirstType getFirstTypeWithSubTypes(Integer typeId) {
		FirstType st = getById(typeId);
		
		st.setSubTypes(getSubTypes(typeId));
		
		return st;
	}
	
	/**
	 * ��ȡһ�����൫��ȡ������������б�
	 * @param typeId
	 * @return
	 */
	public FirstType getFirstTypeWithoutSubTypes(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * ȡ������һ�����࣬���������������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FirstType> getAllFirstTypesWithoutSubTypes() {
		String hql = "from FirstType";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * ��ȡһ�����൫��ȡ������������б�
	 * @param typeId
	 * @return
	 */
	public FirstType getFirstType(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * �ж�һ���������Ƿ����
	 * @param typeName
	 * @return ����true������ڣ����򷵻�false
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
	 * ȡ��һ������������ӷ����б�
	 * @param ftId һ������Id
	 * @return �ӷ����б�
	 */
	@SuppressWarnings("unchecked")
	public List<SecondType> getSubTypes(Integer ftId) {
		String hql = "from SecondType st where st.superId = :superId";
		Query query = getSession().createQuery(hql);
		query.setInteger("superId", ftId);
		return query.list();
	}
}
