package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.OrderDetail;

public class OrderDetailDaoHibernate extends HibernateGenericDao<OrderDetail> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete OrderDetail od where od.odId = :odId";
		Query query = getSession().createQuery(hql);
		query.setInteger("odId", (Integer)id);
		query.executeUpdate();
	}
}
