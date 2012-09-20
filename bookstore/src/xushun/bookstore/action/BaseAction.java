package xushun.bookstore.action;

import xushun.bookstore.service.AdministorManager;
import xushun.bookstore.service.BookCommentManager;
import xushun.bookstore.service.BookManager;
import xushun.bookstore.service.BookTypeManager;
import xushun.bookstore.service.MemberManager;
import xushun.bookstore.service.OrderManager;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有Action的基类，里面存放所有业务对象，方便其子类的应用
 * @author xushun
 *
 */
public abstract class BaseAction extends ActionSupport {
	
	protected MemberManager memberManager ;
	protected AdministorManager adminManager;
	protected BookManager bookManager;
	protected BookTypeManager bookTypeManager;
	protected OrderManager orderManager;
	protected BookCommentManager commentManager;
	
	protected int pageNo = 1;      /** 分页号 */
	protected int pageSize = 10;   /** 每页存放记录数 */

	
	public MemberManager getMemberManager() {
		return memberManager;
	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

	public BookTypeManager getBookTypeManager() {
		return bookTypeManager;
	}

	public void setBookTypeManager(BookTypeManager bookTypeManager) {
		this.bookTypeManager = bookTypeManager;
	}

	public BookManager getBookManager() {
		return bookManager;
	}

	public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
	}

	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public BookCommentManager getCommentManager() {
		return commentManager;
	}

	public void setCommentManager(BookCommentManager commentManager) {
		this.commentManager = commentManager;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public AdministorManager getAdminManager() {
		return adminManager;
	}

	public void setAdminManager(AdministorManager adminManager) {
		this.adminManager = adminManager;
	}
	
	
	
}
