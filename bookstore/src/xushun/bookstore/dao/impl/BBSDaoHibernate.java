package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.BBS;

public class BBSDaoHibernate extends HibernateGenericDao<BBS> {
	
	@Override
	public void removeById(Serializable id) {
		String hql = "delete BBS bbs od where bbs.bbsId = :bbsId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bbsId", (Integer)id);
		query.executeUpdate();
	}
}
