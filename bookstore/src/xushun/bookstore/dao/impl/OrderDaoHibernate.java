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
	 * 更改订单的状态
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
	 * 获取订单号对应的订单详情.即书目(书目，数量，价格)列表
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
	 * 根据订单详情号删除订单详情
	 * @param odId
	 */
	public void removeOrderDetail(Integer odId) {
		String hql = "delete OrderDetail od where od.odId = :odId";
		Query query = getSession().createQuery(hql);
		query.setInteger("odId", odId);
		query.executeUpdate();
	}
	
	/**
	 * 分页订单
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
	 * 分页订单
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
