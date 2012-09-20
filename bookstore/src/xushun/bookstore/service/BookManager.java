package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.Book;
import xushun.bookstore.util.DataPage;

public interface BookManager {
	
	/**
	 * ���ͼ��
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception;
	
	/**
	 * ͨ��bookId����ͼ��
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public Book getBookById(Integer bookId) throws Exception ;
	
	/**
	 * ����ͼ�������
	 * @param book
	 * @throws Exception
	 */
	public void updateBook(Book book) throws Exception;

	/**
	 * ɾ��ͼ��
	 * @param book
	 * @throws Exception
	 */
	public void removeBook(Book book) throws Exception ;
	
	/**
	 * ͨ��Idɾ��ͼ��
	 * @param bookId
	 * @throws Exception
	 */
	public void removeBookById(Integer bookId) throws Exception ;
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ������ģ��ƥ�䣬��ҳ��ѯ
	 * @param bookName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksByName(String bookName,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * �޸���Ŀ��
	 * @param bookId
	 * @param nowCount
	 * @throws Exception
	 */
	public void modifyBookNowCount(Integer bookId , int nowCount) throws Exception;
	
	/**
	 * �������������
	 * @param bookId
	 * @param increment ���ӵ�����
	 * @throws Exception
	 */
	public void increaseBookNowCount(Integer bookId, int increment) throws Exception;
	
	/**
	 * �������������
	 * @param bookId
	 * @param decrement ���ٵ�����
	 * @throws Exception
	 */
	public void decreaseBookNowCount(Integer bookId, int decrement) throws Exception;
	
	/**
	 * �޸����������
	 * @param bookId
	 * @param saleCount 
	 * @throws Exception
	 */
	public void modifyBookSaleCount(Integer bookId , int saleCount) throws Exception ;
	
	/**
	 * �������������
	 * @param bookId
	 * @param increment ���ӵ�����
	 * @throws Exception
	 */
	public void increaseBookSaleCount(Integer bookId, int increment) throws Exception;
	
	/**
	 * �������������
	 * @param bookId
	 * @param decrement ���ٵ�����
	 * @throws Exception
	 */
	public void decreaseBookSaleCount(Integer bookId, int decrement) throws Exception ;

	/**
	 * ��ø���һ������Id��ͼ���ҳ
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksInFirstType(Integer ftId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ��ø�����������Id��ͼ���ҳ
	 * @param stId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageBooksInSecondType(Integer stId,Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ��ѯ����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Book> selectDataPageNewBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ��ѯ�Ƽ���ͼ��
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageCommendBooks(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ��ȡ�����鼮
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageHotSaleBooks(Integer pageNo,Integer pageSize) throws Exception ;
}
