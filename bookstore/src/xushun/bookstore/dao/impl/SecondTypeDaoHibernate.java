package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;

public class SecondTypeDaoHibernate extends HibernateGenericDao<SecondType> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete SecondType st where st.typeId = :typeId";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * ͨ��typeId��ȡ��������
	 * @param typeId
	 * @return
	 */
	public SecondType getSecondType(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * ȡ�ö������ಢͬʱ������ϼ�����
	 * @param typeId
	 * @return
	 */
	public SecondType getSecondTypeWithSuperType(Integer typeId) {
		SecondType st = getById(typeId);

		String hql = "from FirstType ft where ft.typeId = :typeId ";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", st.getSuperId());
		FirstType ft = (FirstType)query.uniqueResult();
		
		// ��ȡ��һ�����Ҳ��ͨ��ע��FirstTypeDaoHibernate��ȡ��
		
		st.setSuperType(ft);
		
		return st;
	}
	
	/**
	 * ���·�����
	 * @param typeId
	 * @param typeName
	 */
	public void updateTypeName(Integer typeId, String typeName) {
		String hql = "update SecondType st set st.typeName = :typeName st.lastModifyTime = :lastModifyTime where st.typeId = :typeId";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", typeId);
		query.setString("typeName", typeName);
		query.setLong("lastModifyTime", System.currentTimeMillis());
		query.executeUpdate();
	}
}
