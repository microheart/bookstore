package xushun.bookstore.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import xushun.bookstore.model.Book;
import xushun.bookstore.util.DataPage;

public class BookDaoHibernate extends HibernateGenericDao<Book> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete Book book where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", (Integer)id);
		query.executeUpdate();
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book";
		return pagedQuery(hql, pageNo, pageSize);		
	}
	
	/**
	 * ������ģ��ƥ�䣬��ҳ��ѯ
	 * @param bookName
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooksByName(String bookName,Integer pageNo,Integer pageSize) {
		String hql = "from Book book where book.bookName like ?";
		return pagedQuery(hql, pageNo, pageSize, "%"+bookName+"%");
	}
	
	/**
	 * ��ѯ����
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageNewBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book where book.isNewBook = 'T' order by book.inTime desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * �����鼮
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageHotSaleBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book order by book.saleCount desc";
		return pagedQuery(hql, pageNo, pageSize);
	}	
	
	/**
	 * ��ѯ�Ƽ���ͼ��
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageCommendBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book where book.isCommend = 'T'";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * �޸���Ŀ��
	 * @param bookId
	 * @param nowCount
	 */
	public void updateBookNowCount(Integer bookId , int nowCount) {
		String hql = "update Book book set book.nowCount = :nowCount where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("nowCount", nowCount);
		query.executeUpdate();
	}
	
	/**
	 * �������������
	 * @param bookId
	 * @param increment ���ӵ�����
	 */
	public void increaseBookNowCount(Integer bookId, int increment) {
		String hql = "update Book book set book.nowCount = book.nowCount + :increment where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("increment", increment);
		query.executeUpdate();
	}
	
	/**
	 * �������������
	 * @param bookId
	 * @param decrement ���ٵ�����
	 */
	public void decreaseBookNowCount(Integer bookId, int decrement) {
		String hql = "update Book book set book.nowCount = book.nowCount - :decrement where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("decrement", decrement);
		query.executeUpdate();
	}
	
	/**
	 * �޸����������
	 * @param bookId
	 * @param nowCount
	 */
	public void updateBookSaleCount(Integer bookId , int saleCount) {
		String hql = "update Book book set book.saleCount = :saleCount where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("saleCount", saleCount);
		query.executeUpdate();
	}
	
	/**
	 * �������������
	 * @param bookId
	 * @param increment ���ӵ�����
	 */
	public void increaseBookSaleCount(Integer bookId, int increment) {
		String hql = "update Book book set book.saleCount = book.saleCount + :increment where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("increment", increment);
		query.executeUpdate();
	}
	
	/**
	 * �������������
	 * @param bookId
	 * @param decrement ���ٵ�����
	 */
	public void decreaseBookSaleCount(Integer bookId, int decrement) {
		String hql = "update Book book set book.saleCount = book.saleCount - :decrement where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("decrement", decrement);
		query.executeUpdate();
	}
	
	/**
	 * ��ø���һ������Id��ͼ���ҳ
	 * @param ftId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooksInFirstType(Integer ftId,Integer pageNo,Integer pageSize) {
		String hql= "select typeId from SecondType where superId = :superId";
		Query query = getSession().createQuery(hql);
		query.setInteger("superId", ftId);
		List list = query.list();
		StringBuilder builder = new StringBuilder();
		builder.append("from Book book where book.typeId in ( ");
		
		// �����ѯ���Ϊ��
		if(list.isEmpty())
			return new DataPage();
		
		int length = list.size();
		for(int i = 0 ; i < length ; i++) {
			builder.append(Integer.parseInt((list.get(i).toString())));
			if(i != length - 1)
				builder.append(",");
		}
		
		builder.append(" )");
		
		return pagedQuery(builder.toString(), pageNo, pageSize);
	}
	
	/**
	 * ��ø�����������Id��ͼ���ҳ
	 * @param stId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooksInSecondType(Integer stId,Integer pageNo,Integer pageSize) {
		// ���в����������ֻ�����ʺţ���������:typeId���Ƶ�
		String hql = "from Book book where book.typeId = ?";
		
		return pagedQuery(hql, pageNo, pageSize, stId);
	}
	
}
