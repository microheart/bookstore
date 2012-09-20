package xushun.bookstore.service.impl;

import xushun.bookstore.dao.impl.BookDaoHibernate;
import xushun.bookstore.model.Book;
import xushun.bookstore.service.BookManager;
import xushun.bookstore.util.DataPage;

public class BookManagerImpl implements BookManager {

	private BookDaoHibernate bookDao;
	
	public void addBook(Book book) throws Exception {
		bookDao.insert(book);
	}
	
	public Book getBookById(Integer bookId) throws Exception {
		return bookDao.getById(bookId);
	}

	public void decreaseBookNowCount(Integer bookId, int decrement)
			throws Exception {
		bookDao.decreaseBookNowCount(bookId, decrement);
	}

	public void decreaseBookSaleCount(Integer bookId, int decrement)
			throws Exception {
		bookDao.decreaseBookSaleCount(bookId, decrement);
	}

	public void increaseBookNowCount(Integer bookId, int increment)
			throws Exception {
		bookDao.increaseBookNowCount(bookId, increment);
	}

	public void increaseBookSaleCount(Integer bookId, int increment)
			throws Exception {
		bookDao.increaseBookSaleCount(bookId, increment);
	}

	public void modifyBookNowCount(Integer bookId, int nowCount)
			throws Exception {
		bookDao.updateBookNowCount(bookId, nowCount);
	}

	public void modifyBookSaleCount(Integer bookId, int saleCount)
			throws Exception {
		bookDao.updateBookSaleCount(bookId, saleCount);
	}

	public void removeBook(Book book) throws Exception {
		bookDao.remove(book);
	}

	public void removeBookById(Integer bookId) throws Exception {
		bookDao.removeById(bookId);
	}

	public DataPage<Book> selectDataPageBooks(Integer pageNo, Integer pageSize)
			throws Exception {
		return bookDao.selectDataPageBooks(pageNo, pageSize);
	}

	public DataPage<Book> selectDataPageBooksByName(String bookName,
			Integer pageNo, Integer pageSize) throws Exception {
		return bookDao.selectDataPageBooksByName(bookName, pageNo, pageSize);
	}
	
	public DataPage<Book> selectDataPageBooksInFirstType(Integer ftId,
			Integer pageNo, Integer pageSize) throws Exception {
		return bookDao.selectDataPageBooksInFirstType(ftId, pageNo, pageSize);
	}
	
	public DataPage<Book> selectDataPageBooksInSecondType(Integer stId,
			Integer pageNo, Integer pageSize) throws Exception {
		return bookDao.selectDataPageBooksInSecondType(stId, pageNo, pageSize);
	}

	public void updateBook(Book book) throws Exception {
		bookDao.update(book);
	}
	
	public DataPage<Book> selectDataPageCommendBooks(Integer pageNo,
			Integer pageSize) throws Exception {
		return bookDao.selectDataPageCommendBooks(pageNo, pageSize);
	}
	
	public DataPage<Book> selectDataPageNewBooks(Integer pageNo,
			Integer pageSize) throws Exception {
		return bookDao.selectDataPageNewBooks(pageNo, pageSize);
	}
	
	public DataPage<Book> selectDataPageHotSaleBooks(Integer pageNo,
			Integer pageSize) throws Exception {
		return bookDao.selectDataPageHotSaleBooks(pageNo, pageSize);
	}

	public BookDaoHibernate getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDaoHibernate bookDao) {
		this.bookDao = bookDao;
	}
	
	
}
