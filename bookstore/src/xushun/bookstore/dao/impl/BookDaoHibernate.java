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
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book";
		return pagedQuery(hql, pageNo, pageSize);		
	}
	
	/**
	 * 按书名模糊匹配，分页查询
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
	 * 查询新书
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageNewBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book where book.isNewBook = 'T' order by book.inTime desc";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * 热销书籍
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageHotSaleBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book order by book.saleCount desc";
		return pagedQuery(hql, pageNo, pageSize);
	}	
	
	/**
	 * 查询推荐的图书
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageCommendBooks(Integer pageNo,Integer pageSize) {
		String hql = "from Book book where book.isCommend = 'T'";
		return pagedQuery(hql, pageNo, pageSize);
	}
	
	/**
	 * 修改书的库存
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
	 * 增加书库存的数量
	 * @param bookId
	 * @param increment 增加的数量
	 */
	public void increaseBookNowCount(Integer bookId, int increment) {
		String hql = "update Book book set book.nowCount = book.nowCount + :increment where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("increment", increment);
		query.executeUpdate();
	}
	
	/**
	 * 减少书库存的数量
	 * @param bookId
	 * @param decrement 减少的数量
	 */
	public void decreaseBookNowCount(Integer bookId, int decrement) {
		String hql = "update Book book set book.nowCount = book.nowCount - :decrement where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("decrement", decrement);
		query.executeUpdate();
	}
	
	/**
	 * 修改书的销售量
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
	 * 增加书的销售量
	 * @param bookId
	 * @param increment 增加的数量
	 */
	public void increaseBookSaleCount(Integer bookId, int increment) {
		String hql = "update Book book set book.saleCount = book.saleCount + :increment where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("increment", increment);
		query.executeUpdate();
	}
	
	/**
	 * 减少书的销售量
	 * @param bookId
	 * @param decrement 减少的数量
	 */
	public void decreaseBookSaleCount(Integer bookId, int decrement) {
		String hql = "update Book book set book.saleCount = book.saleCount - :decrement where book.bookId = :bookId";
		Query query = getSession().createQuery(hql);
		query.setInteger("bookId", bookId);
		query.setInteger("decrement", decrement);
		query.executeUpdate();
	}
	
	/**
	 * 获得给定一级分类Id下图书分页
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
		
		// 如果查询结果为空
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
	 * 获得给定二级分类Id下图书分页
	 * @param stId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Book> selectDataPageBooksInSecondType(Integer stId,Integer pageNo,Integer pageSize) {
		// 对有参数的情况下只能用问号，而不能用:typeId类似的
		String hql = "from Book book where book.typeId = ?";
		
		return pagedQuery(hql, pageNo, pageSize, stId);
	}
	
}
