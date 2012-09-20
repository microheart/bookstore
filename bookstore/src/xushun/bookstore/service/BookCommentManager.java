package xushun.bookstore.service;

import xushun.bookstore.model.BookComment;
import xushun.bookstore.util.DataPage;

public interface BookCommentManager {
	
	
	public void addBookComment(BookComment bookComment) throws Exception;
	
	public void updateBookComment(BookComment bookComment) throws Exception ;
	
	public BookComment getBookCommentById(Integer commentId) throws Exception ;
	
	public void removeBookCommentById(Integer commentId) throws Exception ;
	
	public DataPage<BookComment> selectDataPageBookComment(Integer bookId, Integer pageNo, Integer pageSize) throws Exception ;
	

}
