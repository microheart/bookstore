package xushun.bookstore.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;

import xushun.bookstore.model.BookComment;
import xushun.bookstore.util.DataPage;

public class BookCommentDaoHibernate extends HibernateGenericDao<BookComment> {

	@Override
	public void removeById(Serializable id) {
		String hql = "delete BookComment bc where bc.commentId = :commentId";
		Query query = getSession().createQuery(hql);
		query.setInteger("commentId", (Integer)id);
		query.executeUpdate();
	}
	
	public DataPage<BookComment> selectDataPageBookComment(Integer bookId, Integer pageNo,Integer pageSize) throws Exception {
		
		String hql = "from BookComment comment where comment.bookId = ?";
		
		return pagedQuery(hql, pageNo, pageSize, bookId);
	}
}
