package xushun.bookstore.service.impl;

import xushun.bookstore.dao.impl.BookCommentDaoHibernate;
import xushun.bookstore.model.BookComment;
import xushun.bookstore.service.BookCommentManager;
import xushun.bookstore.util.DataPage;

public class BookCommentManagerImpl implements BookCommentManager {
	
	private BookCommentDaoHibernate commentDao;

	public void addBookComment(BookComment bookComment) throws Exception {
		commentDao.insert(bookComment);
	}

	public BookComment getBookCommentById(Integer commentId) throws Exception {
		return commentDao.getById(commentId);
	}

	public void removeBookCommentById(Integer commentId) throws Exception {
		commentDao.removeById(commentId);
	}

	public DataPage<BookComment> selectDataPageBookComment(Integer bookId,
			Integer pageNo, Integer pageSize) throws Exception {
		return commentDao.selectDataPageBookComment(bookId, pageNo, pageSize);
	}

	public void updateBookComment(BookComment bookComment) throws Exception {
		commentDao.update(bookComment);
	}

	public BookCommentDaoHibernate getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(BookCommentDaoHibernate commentDao) {
		this.commentDao = commentDao;
	}
	
	

}
