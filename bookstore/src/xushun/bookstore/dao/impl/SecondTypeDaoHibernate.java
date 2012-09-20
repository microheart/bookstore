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
	 * 通过typeId获取二级分类
	 * @param typeId
	 * @return
	 */
	public SecondType getSecondType(Integer typeId) {
		return getById(typeId);
	}
	
	/**
	 * 取得二级分类并同时获得其上级分类
	 * @param typeId
	 * @return
	 */
	public SecondType getSecondTypeWithSuperType(Integer typeId) {
		SecondType st = getById(typeId);

		String hql = "from FirstType ft where ft.typeId = :typeId ";
		Query query = getSession().createQuery(hql);
		query.setInteger("typeId", st.getSuperId());
		FirstType ft = (FirstType)query.uniqueResult();
		
		// 获取上一级类别也可通过注入FirstTypeDaoHibernate来取得
		
		st.setSuperType(ft);
		
		return st;
	}
	
	/**
	 * 更新分类名
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
