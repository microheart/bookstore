package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.Book;
import xushun.bookstore.util.DataPage;

public interface BookManager {
	
	/**
	 * 添加图书
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception;
	
	/**
	 * 通过bookId查找图书
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public Book getBookById(Integer bookId) throws Exception ;
	
	/**
	 * 更新图书的资料
	 * @param book
	 * @throws Exception
	 */
	public void updateBook(Book book) throws Exception;

	/**
	 * 删除图书
	 * @param book
	 * @throws Exception
	 */
	public void removeBook(Book book) throws Exception ;
	
	/**
	 * 通过Id删除图书
	 * @param bookId
	 * @throws Exception
	 */
	public void removeBookById(Integer bookId) throws Exception ;
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 按书名模糊匹配，分页查询
	 * @param bookName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksByName(String bookName,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 修改书的库存
	 * @param bookId
	 * @param nowCount
	 * @throws Exception
	 */
	public void modifyBookNowCount(Integer bookId , int nowCount) throws Exception;
	
	/**
	 * 增加书库存的数量
	 * @param bookId
	 * @param increment 增加的数量
	 * @throws Exception
	 */
	public void increaseBookNowCount(Integer bookId, int increment) throws Exception;
	
	/**
	 * 减少书库存的数量
	 * @param bookId
	 * @param decrement 减少的数量
	 * @throws Exception
	 */
	public void decreaseBookNowCount(Integer bookId, int decrement) throws Exception;
	
	/**
	 * 修改书的销售量
	 * @param bookId
	 * @param saleCount 
	 * @throws Exception
	 */
	public void modifyBookSaleCount(Integer bookId , int saleCount) throws Exception ;
	
	/**
	 * 增加书的销售量
	 * @param bookId
	 * @param increment 增加的数量
	 * @throws Exception
	 */
	public void increaseBookSaleCount(Integer bookId, int increment) throws Exception;
	
	/**
	 * 减少书的销售量
	 * @param bookId
	 * @param decrement 减少的数量
	 * @throws Exception
	 */
	public void decreaseBookSaleCount(Integer bookId, int decrement) throws Exception ;

	/**
	 * 获得给定一级分类Id下图书分页
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksInFirstType(Integer ftId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 获得给定二级分类Id下图书分页
	 * @param stId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksInSecondType(Integer stId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 查询新书
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageNewBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 查询推荐的图书
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageCommendBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 获取热销书籍
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageHotSaleBooks(Integer pageNo,Integer pageSize) throws Exception ;
}
