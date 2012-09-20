package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.Order;
import xushun.bookstore.model.OrderDetail;
import xushun.bookstore.util.DataPage;

public interface OrderManager {
	
	/**
	 * 添加订单
	 * @param order
	 * @throws Exception
	 */
	public void addOrder(Order order) throws Exception ;
	
	/**
	 * 添加订单项
	 * @param orderDetail
	 * @throws Exception
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * 通过订单详情Id获取订单详情
	 * @param orderDetailId
	 * @return
	 * @throws Exception
	 */
	public OrderDetail getOrderDetailById(Integer orderDetailId) throws Exception ;

	/**
	 * 获取订单通过Id
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public Order getOrderById(Integer orderId) throws Exception ;
	
	/**
	 * 通过订单号获取订单下商品信息
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId) throws Exception ;
	
	/**
	 * 更新订单详情
	 * @param orderDetail
	 * @throws Exception
	 */
	public void updateOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * 更新订单
	 * @param order
	 * @throws Exception
	 */
	public void updateOrder(Order order) throws Exception ;
	
	/**
	 * 通过Id删除订单详情
	 * @param orderDetailId
	 * @throws Exception
	 */
	public void removeOrderDetailById(Integer orderDetailId) throws Exception ;
	
	/**
	 * 删除订单通过Id
	 * @param orderId
	 * @throws Exception
	 */
	public void removeOrderById(Integer orderId) throws Exception ;
	
	/**
	 * 计算订单金额
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public double countAmountByOrderId(Integer orderId) throws Exception ;
	
	/**
	 * 分页订单
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrders(Integer memberId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 分页订单（管理员查看的）
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrders(Integer pageNo,Integer pageSize) throws Exception;
	
	/**
	 * 根据订单状态获取分页
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Order> selectDataPageOrdersByStatus(Integer status,Integer pageNo,Integer pageSize) throws Exception ;
}
