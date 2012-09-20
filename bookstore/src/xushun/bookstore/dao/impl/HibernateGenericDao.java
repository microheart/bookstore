package xushun.bookstore.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import xushun.bookstore.dao.BaseDao;
import xushun.bookstore.util.DataPage;

/**
 * Hibernate Dao的泛型基类. <p/> 继承于Spring的<code>HibernateDaoSupport</code>
 * 提供分页方法和若干便捷查询方法，并对返回值作了泛型类型转换.
 * 
 * @author xushun
 * @see HibernateDaoSupport
 */

@SuppressWarnings("unchecked")
public class HibernateGenericDao<T> extends HibernateDaoSupport implements
		BaseDao<T> {

	protected Class<T> entityClass;// DAO所管理的Entity类型.

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public HibernateGenericDao() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.get()方法返回实体对象. 如果对象不存在，则返回null.
	 */
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常.
	 */
	public T loadById(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.get()方法返回实体对象. 如果对象不存在，则返回null.
	 */
	public T get(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 根据ID获取对象. 实际调用Hibernate的session.load()方法返回实体或其proxy对象. 如果对象不存在，抛出异常.
	 */
	public T load(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * 获取全部对象. 返回一个List，0个多个对象
	 */
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * 插入一个对象
	 * 
	 * @param o
	 */
	public void insert(Object entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param entity
	 */
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 新增或更新一个对象
	 * 
	 * @param entity
	 */
	public void insertOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * 删除一个对象
	 * 
	 * @param entity
	 */
	public void remove(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 通过ID删除一个对象
	 * 
	 * @param id
	 */
	public void removeById(Serializable id) {
		getHibernateTemplate().delete(getById(id));
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	public void clear() {
		getHibernateTemplate().clear();
	}

	/**
	 * 取得对象的主键名,辅助函数.
	 */
	public String getIdName(Class clazz) {
		Assert.notNull(clazz);
		ClassMetadata meta = getSessionFactory().getClassMetadata(clazz);
		Assert.notNull(meta, "Class " + clazz
				+ " not define in hibernate session factory.");
		String idName = meta.getIdentifierPropertyName();
		Assert.hasText(idName, clazz.getSimpleName()
				+ " has no identifier property define.");
		return idName;
	}

	/**
	 * 创建Query对象.
	 * 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
	 * 留意可以连续设置,如下：
	 * 
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 
	 * 调用方式如下：
	 * 
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 * 
	 * @param values
	 *            可变参数.
	 */
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}

	public SQLQuery createSqlQuery(String sql, Object... values) {
		Assert.hasText(sql);
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		for (int i = 0; i < values.length; i++) {
			sqlQuery.setParameter(i, values[i]);
		}
		return sqlQuery;
	}

	/**
	 * 分页查询函数，使用hql.
	 * 
	 * @param pageNo
	 *            页号,从1开始.
	 * @param pageSize
	 *            每页记录数
	 */
	public DataPage<T> pagedQuery(String hql, Integer pageNo, Integer pageSize,
			Object... values) {
		// 是否设置分页号，每页的分页数
		if (pageNo == null || pageSize == null) {
			List list = createQuery(hql, values).list();
			// 如果查询结果为空，则返会没有数据内容的分页，否则返回全部结果
			if (list == null || list.size() == 0) {
				return new DataPage();
			} else {
				return new DataPage(0, list.size(), list.size(), list);
			}
		}
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		// Count查询 ，查询符合条件的总记录数
		String countQueryString = " select count(*) "
				+ removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		int totalCount = ((Long) countlist.get(0)).intValue();

		if (totalCount < 1)
			return new DataPage();

		// 实际查询返回分页对象
		int startIndex = DataPage.getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new DataPage(startIndex, totalCount, pageSize, list);
	}

	/**
	 * 分页查询函数，使用sql.
	 * 
	 * @param pageNo
	 *            页号,从1开始.
	 * @param pageSize
	 *            每页记录数
	 */
	public DataPage pagedSqlQuery(String sql, Integer pageNo, Integer pageSize,
			Object... values) {
		if (pageNo == null || pageSize == null) {
			List list = createSqlQuery(sql, values).list();
			if (list == null || list.size() == 0) {
				return new DataPage();
			} else {
				return new DataPage(0, list.size(), list.size(), list);
			}
		}

		Assert.hasText(sql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");

		// Count查询
		String countQueryString = " select count(*) "
				+ removeSelect(removeOrders(sql));

		int count = 0;

		List countList;
		// 如果有order 且order后 存在参数;
		if (sql.indexOf("order") != -1
				&& (sql.substring(sql.indexOf("order")).indexOf("?")) != -1) {
			String sqlTemp = sql.substring(sql.indexOf("order"));
			// 数出 order 后面参数的个数;
			while (sqlTemp.indexOf("?") >= 0) {
				sqlTemp = sqlTemp.substring(sqlTemp.indexOf("?") + 1);
				count++;
			}
			Object[] valuesCountParam = new Object[values.length - count];
			// 生成select count(*)的参数;
			for (int i = 0; i < values.length - count; i++) {
				valuesCountParam[i] = values[i];
			}
			countList = findBySql(countQueryString, valuesCountParam);
		} else {
			countList = findBySql(countQueryString, values);
		}
		// int totalCount = ((Long) countlist.get(0)).intValue();
		int totalCount = Integer.parseInt(countList.get(0).toString());
		if (totalCount < 1)
			return new DataPage();
		// 实际查询返回分页对象
		int startIndex = DataPage.getStartOfPage(pageNo, pageSize);
		SQLQuery sqlQuery = createSqlQuery(sql, values);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new DataPage(startIndex, totalCount, pageSize, list);
	}

	/**
	 * getHibernateTemplate 关于 sql的findby 方法; pagedSqlQuery 调用;
	 * 
	 * @param countQueryString
	 * @param values
	 * @return
	 * @throws DataAccessException
	 */
	public List findBySql(final String countQueryString, final Object[] values)
			throws DataAccessException {
		Assert.hasText(countQueryString, "countQueryString must not be null");
		return (List) this.getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Assert.hasText(countQueryString);
						Query queryObject = session
								.createSQLQuery(countQueryString);
						if (values != null) {
							for (int i = 0; i < values.length; i++) {
								queryObject.setParameter(i, values[i]);
							}
						}
						return queryObject.list();
					}
				});
	}

	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery. 如果有“fetch”，则去掉
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql
				+ " must has a keyword 'from'");
		return hql.substring(beginPos).replace("fetch", "");
	}

	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 * 
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

}
