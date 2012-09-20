package xushun.bookstore.action;

import java.util.Map;

import xushun.bookstore.model.BookComment;
import xushun.bookstore.model.Member;
import xushun.bookstore.service.BookCommentManager;

import com.opensymphony.xwork2.ActionContext;

public class BookCommentAction extends BaseAction {
	
	private int commentId;
	private int bookId;
	private String content;
	private BookComment comment;
	
	public String addComment() throws Exception {
		
		BookComment comment = new BookComment();
		
		Map session = ActionContext.getContext().getSession();
		Member member = (Member)session.get("member");
		
		comment.setMemberId(member.getMemberId());
		comment.setLoginName(member.getLoginName());
		comment.setBookId(getBookId());
		comment.setContent(getContent());
		comment.setCommentTime(System.currentTimeMillis());
		
		commentManager.addBookComment(comment);
		
		return SUCCESS;
	}
	

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public BookComment getComment() {
		return comment;
	}

	public void setComment(BookComment comment) {
		this.comment = comment;
	}

	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	

}
