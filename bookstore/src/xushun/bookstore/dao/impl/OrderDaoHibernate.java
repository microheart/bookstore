package xushun.bookstore.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import xushun.bookstore.model.Order;
import xushun.bookstore.model.OrderDetail;
import xushun.bookstore.util.DataPage;

public class OrderDaoHibernate extends HibernateGenericDao<Order> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete Order o where o.orderId = :orderId";
		Query query = getSession().createQuery(hql);
		query.setInteger("orderId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * ���Ķ�����״̬
	 * @param orderId
	 * @param status
	 */
	public void changeOrderStaus(Integer orderId,Integer status) {
		String hql = "update Order o set o.status = :status where o.orderId = :orderId";
		Query query = getSession().createQuery(hql);
		query.setInteger("orderId", orderId);
		query.setInteger("status", status);
		query.executeUpdate();
	}
	
	/**
	 * ��ȡ�����Ŷ�Ӧ�Ķ�������.����Ŀ(��Ŀ���������۸�)�б�
	 * @param orderId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> listOrderDetailByOrderId(Integer orderId) {
		String hql = "from OrderDetail od where od.orderId = :orderId";
		Query query = getSession().createQuery(hql);
		query.setInteger("orderId", orderId);
		return query.list();
	}
	
	/**
	 * ���ݶ��������ɾ����������
	 * @param odId
	 */
	public void removeOrderDetail(Integer odId) {
		String hql = "delete OrderDetail od where od.odId = :odId";
		Query query = getSession().createQuery(hql);
		query.setInteger("odId", odId);
		query.executeUpdate();
	}
	
	/**
	 * ��ҳ����
	 * @param memberId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrdersWithoutOrderDetails(Integer memberId,Integer pageNo, Integer pageSize) {
		String hql = "from Order o where o.memberId = ?";
		
		return pagedQuery(hql, pageNo, pageSize, memberId);
	}
	
	public DataPage<Order> selectDataPageOrders(Integer pageNo,Integer pageSize) {
		String hql = "from Order ";
		
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	public DataPage<Order> selectDataPageOrdersByStatus(Integer status,Integer pageNo,Integer pageSize) {
		String hql = "from Order o where o.status = ? ";
		
		return pagedQuery(hql, pageNo, pageSize,status);
	}
	
	/**
	 * ��ҳ����
	 * @param memberId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrdersWithOrderDetails(Integer memberId, Integer pageNo,Integer pageSize) {
		DataPage<Order> pages = selectDataPageOrdersWithoutOrderDetails(memberId, pageNo, pageSize);
		
		if(pages.getTotalCount() > 0) {
			List<Order> orders = pages.getData();
			
			for(Order order:orders) {
				order.setOrderDetails(listOrderDetailByOrderId(order.getOrderId()));
			}
			
		}
		
		return pages;
	}
}
