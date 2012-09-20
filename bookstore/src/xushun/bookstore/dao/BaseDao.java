package xushun.bookstore.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	T getById(Serializable id) throws Exception;

	List<T> getAll();

	void insert(Object o);
	
	void update(Object o);
	
	void insertOrUpdate(Object o) ;
	
	void remove(Object o);

	void removeById(Serializable id);

	/**
	 * ��ȡEntity�����������.
	 */
	String getIdName(Class clazz);
}
