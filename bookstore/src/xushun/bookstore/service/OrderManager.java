package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.Order;
import xushun.bookstore.model.OrderDetail;
import xushun.bookstore.util.DataPage;

public interface OrderManager {
	
	/**
	 * ��Ӷ���
	 * @param order
	 * @throws Exception
	 */
	public void addOrder(Order order) throws Exception ;
	
	/**
	 * ��Ӷ�����
	 * @param orderDetail
	 * @throws Exception
	 */
	public void addOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * ͨ����������Id��ȡ��������
	 * @param orderDetailId
	 * @return
	 * @throws Exception
	 */
	public OrderDetail getOrderDetailById(Integer orderDetailId) throws Exception ;

	/**
	 * ��ȡ����ͨ��Id
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public Order getOrderById(Integer orderId) throws Exception ;
	
	/**
	 * ͨ�������Ż�ȡ��������Ʒ��Ϣ
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public List<OrderDetail> getOrderDetailsByOrderId(Integer orderId) throws Exception ;
	
	/**
	 * ���¶�������
	 * @param orderDetail
	 * @throws Exception
	 */
	public void updateOrderDetail(OrderDetail orderDetail) throws Exception ;
	
	/**
	 * ���¶���
	 * @param order
	 * @throws Exception
	 */
	public void updateOrder(Order order) throws Exception ;
	
	/**
	 * ͨ��Idɾ����������
	 * @param orderDetailId
	 * @throws Exception
	 */
	public void removeOrderDetailById(Integer orderDetailId) throws Exception ;
	
	/**
	 * ɾ������ͨ��Id
	 * @param orderId
	 * @throws Exception
	 */
	public void removeOrderById(Integer orderId) throws Exception ;
	
	/**
	 * ���㶩�����
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public double countAmountByOrderId(Integer orderId) throws Exception ;
	
	/**
	 * ��ҳ����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrders(Integer memberId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ��ҳ����������Ա�鿴�ģ�
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Order> selectDataPageOrders(Integer pageNo,Integer pageSize) throws Exception;
	
	/**
	 * ���ݶ���״̬��ȡ��ҳ
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Order> selectDataPageOrdersByStatus(Integer status,Integer pageNo,Integer pageSize) throws Exception ;
}
