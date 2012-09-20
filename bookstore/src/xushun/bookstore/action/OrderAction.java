package xushun.bookstore.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xushun.bookstore.model.Book;
import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.Member;
import xushun.bookstore.model.Order;
import xushun.bookstore.model.OrderDetail;
import xushun.bookstore.util.DataPage;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class OrderAction extends BaseAction {

	private int bookId;
	private int count;
	
	private int orderId;
	private int status;
	private Order order;
	private List<OrderDetail> orderDetails;
	private double amount;
	
	private DataPage<Order> dataPageOfOrder;
	
	private List<FirstType> firstTypes;

	@SuppressWarnings("unchecked")
	public String cart() throws Exception {
		firstTypes = bookTypeManager.getAllFirstTypes();
		orderDetails = (List<OrderDetail>)ActionContext.getContext().getSession().get("orderDetails");
		
		getOrderAmount();

		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String addCartItem() throws Exception {
		Map session = ActionContext.getContext().getSession();
		
		orderDetails = (List<OrderDetail>)session.get("orderDetails");
		
		if(orderDetails == null) {
			orderDetails = new ArrayList<OrderDetail>();
		}
		
		Book book = bookManager.getBookById(bookId);
		if(book != null) {
			
			boolean isExistTheBook = false;
			
			for(OrderDetail orderDetail:orderDetails) {
				if(book.getBookId().equals(orderDetail.getBookId())) {
					orderDetail.setCount(orderDetail.getCount() + 1);
					isExistTheBook = true;
					break;
				}
			}
			
			if(!isExistTheBook){
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setBookId(bookId);
				orderDetail.setBookName(book.getBookName());
				orderDetail.setCount(1);
				orderDetail.setPrice(book.getPrice());
				orderDetail.setRebate(book.getRebate());
				orderDetails.add(orderDetail);			
			}

		}
		
		session.put("orderDetails", orderDetails);
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")	
	public String modifyCartItemCount() throws Exception {
		if(count < 0)
			return SUCCESS;
		
		Map session = ActionContext.getContext().getSession();
		
		orderDetails = (List<OrderDetail>)session.get("orderDetails");	
		
		if(orderDetails != null) {
			for(OrderDetail orderDetail:orderDetails) {
				if(bookId == orderDetail.getBookId()) {
					orderDetail.setCount(count);
					break;
				}
			}
		}
		session.put("orderDetails", orderDetails);
		getOrderAmount();
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String deleteCartItem() throws Exception {
		Map session = ActionContext.getContext().getSession();
		
		orderDetails = (List<OrderDetail>)session.get("orderDetails");	
		
		if(orderDetails != null) {
			for(OrderDetail orderDetail:orderDetails) {
				if(bookId == orderDetail.getBookId()) {
					orderDetails.remove(orderDetail);
					break;
				}
			}
		}
		
		session.put("orderDetails", orderDetails);
		getOrderAmount();
		
		return SUCCESS;
	}
	
	public String checkout() throws Exception {
		Map session = ActionContext.getContext().getSession();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		orderDetails = (List<OrderDetail>)session.get("orderDetails");	
		
		if(getOrderAmount() <= 0 )
			return "nonbook";
		
		return SUCCESS;
	}
	
	public String submitOrder() throws Exception {
		Map session = ActionContext.getContext().getSession();
		
		Member member = (Member)session.get("member");
		orderDetails = (List<OrderDetail>)session.get("orderDetails");
		
		for(OrderDetail orderDetail: orderDetails) {
			Book book = bookManager.getBookById(orderDetail.getBookId());
			book.setNowCount(book.getNowCount() - orderDetail.getCount());
			book.setSaleCount(book.getSaleCount() + orderDetail.getCount());
			bookManager.updateBook(book);
		}
		
		order.setAmount(getOrderAmount());
		order.setMemberId(member.getMemberId());
		order.setOrderDetails(orderDetails);
		order.setOrderTime(System.currentTimeMillis());
		order.setDealTime(0L);
		order.setStatus(0);
		
		orderManager.addOrder(order);
		
		session.remove("orderDetails");
		
		return SUCCESS;
	}
	
	public String viewOrder() throws Exception {
		order = orderManager.getOrderById(orderId);
		
		return SUCCESS;
	}
	
	public String toEditOrder() throws Exception {
		order = orderManager.getOrderById(orderId);
		
		return SUCCESS;
	}
	
	public String editOrder() throws Exception {
		
		Order order = orderManager.getOrderById(orderId);
		
		order.setStatus(getStatus());
		order.setDealTime(System.currentTimeMillis());
		
		orderManager.updateOrder(order);
		return SUCCESS;
	}
	
	public String listOrders() throws Exception {
		Map session = ActionContext.getContext().getSession();
		
		Member member = (Member)session.get("member");
		
		int memberId= member.getMemberId();
		dataPageOfOrder = orderManager.selectDataPageOrders(memberId, pageNo, pageSize);
		return SUCCESS;
	}
	
	public String adminListOrders() throws Exception {
		dataPageOfOrder = orderManager.selectDataPageOrders(pageNo, pageSize);
		
		return SUCCESS;
	}
	
	public String listDealedOrders() throws Exception {
		dataPageOfOrder = orderManager.selectDataPageOrdersByStatus(Order.ORDER_STATUS_DEALED, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	public String listNonDealedOrders() throws Exception {
		dataPageOfOrder = orderManager.selectDataPageOrdersByStatus(Order.ORDER_STATUS_NONDEALED, pageNo, pageSize);
		
		return SUCCESS;
	}
	
	public String deleteOrder() throws Exception {
		orderManager.removeOrderById(orderId);
	
		return SUCCESS;
	}
	
	private double getOrderAmount() {
		if(orderDetails != null) {
			for(OrderDetail orderDetail :orderDetails) {
				amount += orderDetail.getPrice() * orderDetail.getCount() * orderDetail.getRebate();
			}		
		}
		
		return amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<FirstType> getFirstTypes() {
		return firstTypes;
	}

	public void setFirstTypes(List<FirstType> firstTypes) {
		this.firstTypes = firstTypes;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public DataPage<Order> getDataPageOfOrder() {
		return dataPageOfOrder;
	}

	public void setDataPageOfOrder(DataPage<Order> dataPageOfOrder) {
		this.dataPageOfOrder = dataPageOfOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	
}
