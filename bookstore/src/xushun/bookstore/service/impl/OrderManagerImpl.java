package xushun.bookstore.service.impl;

import java.util.List;

import xushun.bookstore.dao.impl.OrderDaoHibernate;
import xushun.bookstore.dao.impl.OrderDetailDaoHibernate;
import xushun.bookstore.model.Order;
import xushun.bookstore.model.OrderDetail;
import xushun.bookstore.service.OrderManager;
import xushun.bookstore.util.DataPage;

public class OrderManagerImpl implements OrderManager {
	
	private OrderDaoHibernate orderDao;
	private OrderDetailDaoHibernate orderDetailDao;

	public void addOrder(Order order) throws Exception {
		orderDao.insert(order);
		int orderId = order.getOrderId();
		
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for(OrderDetail orderDetail:orderDetails) {
			orderDetail.setOrderId(orderId);
			orderDetailDao.insert(orderDetail);
		}
	}
	
	public void addOrderDetail(OrderDetail orderDetail) throws Exception {
		orderDetailDao.insert(orderDetail);
	}
	
	public double countAmountByOrderId(Integer orderId) throws Exception {
		
		List<OrderDetail> orderDetails = orderDao.listOrderDetailByOrderId(orderId);
		
		double amount = 0;
		for(OrderDetail orderDetail:orderDetails) {
			amount += orderDetail.getPrice()*orderDetail.getCount();
		}
		
		return amount;
	}

	public Order getOrderById(Integer orderId) throws Exception {
		Order order = orderDao.getById(orderId);
		
		List<OrderDetail> orderDetails = orderDao.listOrderDetailByOrderId(orderId);
		
		order.setOrderDetails(orderDetails);
		
		return order;
	}
	
	public DataPage<Order> selectDataPageOrders(Integer memberId,Integer pageNo, Integer pageSize) {
		return orderDao.selectDataPageOrdersWithoutOrderDetails(memberId, pageNo, pageSize);
	}
	
	public DataPage<Order> selectDataPageOrders(Integer pageNo, Integer pageSize) {
		return orderDao.selectDataPageOrders(pageNo, pageSize);
	}

	public OrderDetail getOrderDetailById(Integer orderDetailId)
			throws Exception {
		return orderDetailDao.getById(orderDetailId);
	}

	public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId)
			throws Exception {
		return orderDao.listOrderDetailByOrderId(orderId);
	}

	public void removeOrderById(Integer orderId) throws Exception {
		orderDao.removeById(orderId);
	}

	public void removeOrderDetailById(Integer orderDetailId) throws Exception {
		orderDetailDao.removeById(orderDetailId);
	}

	public void updateOrder(Order order) throws Exception {
		orderDao.update(order);
	}

	public void updateOrderDetail(OrderDetail orderDetail) throws Exception {
		orderDetailDao.update(orderDetail);
	}
	
	public DataPage<Order> selectDataPageOrdersByStatus(Integer status,
			Integer pageNo, Integer pageSize) throws Exception {
		return orderDao.selectDataPageOrdersByStatus(status, pageNo, pageSize);
	}

	public OrderDaoHibernate getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDaoHibernate orderDao) {
		this.orderDao = orderDao;
	}

	public OrderDetailDaoHibernate getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(OrderDetailDaoHibernate orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	
}
