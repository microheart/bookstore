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
 * Hibernate Dao�ķ��ͻ���. <p/> �̳���Spring��<code>HibernateDaoSupport</code>
 * �ṩ��ҳ���������ɱ�ݲ�ѯ���������Է���ֵ���˷�������ת��.
 * 
 * @author xushun
 * @see HibernateDaoSupport
 */

@SuppressWarnings("unchecked")
public class HibernateGenericDao<T> extends HibernateDaoSupport implements
		BaseDao<T> {

	protected Class<T> entityClass;// DAO�������Entity����.

	/**
	 * �ڹ��캯���н�����T.class����entityClass.
	 */
	public HibernateGenericDao() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * ����ID��ȡ����. ʵ�ʵ���Hibernate��session.get()��������ʵ�����. ������󲻴��ڣ��򷵻�null.
	 */
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * ����ID��ȡ����. ʵ�ʵ���Hibernate��session.load()��������ʵ�����proxy����. ������󲻴��ڣ��׳��쳣.
	 */
	public T loadById(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * ����ID��ȡ����. ʵ�ʵ���Hibernate��session.get()��������ʵ�����. ������󲻴��ڣ��򷵻�null.
	 */
	public T get(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * ����ID��ȡ����. ʵ�ʵ���Hibernate��session.load()��������ʵ�����proxy����. ������󲻴��ڣ��׳��쳣.
	 */
	public T load(Class<T> entityClass, Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * ��ȡȫ������. ����һ��List��0���������
	 */
	public List<T> getAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}

	/**
	 * ����һ������
	 * 
	 * @param o
	 */
	public void insert(Object entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * ���¶���
	 * 
	 * @param entity
	 */
	public void update(Object entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * ���������һ������
	 * 
	 * @param entity
	 */
	public void insertOrUpdate(Object entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * ɾ��һ������
	 * 
	 * @param entity
	 */
	public void remove(Object entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * ͨ��IDɾ��һ������
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
	 * ȡ�ö����������,��������.
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
	 * ����Query����.
	 * ������Ҫfirst,max,fetchsize,cache,cacheRegion��������õĺ���,�����ڷ���Query����������.
	 * ���������������,���£�
	 * 
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 
	 * ���÷�ʽ���£�
	 * 
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 * 
	 * @param values
	 *            �ɱ����.
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
	 * ��ҳ��ѯ������ʹ��hql.
	 * 
	 * @param pageNo
	 *            ҳ��,��1��ʼ.
	 * @param pageSize
	 *            ÿҳ��¼��
	 */
	public DataPage<T> pagedQuery(String hql, Integer pageNo, Integer pageSize,
			Object... values) {
		// �Ƿ����÷�ҳ�ţ�ÿҳ�ķ�ҳ��
		if (pageNo == null || pageSize == null) {
			List list = createQuery(hql, values).list();
			// �����ѯ���Ϊ�գ��򷵻�û���������ݵķ�ҳ�����򷵻�ȫ�����
			if (list == null || list.size() == 0) {
				return new DataPage();
			} else {
				return new DataPage(0, list.size(), list.size(), list);
			}
		}
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		// Count��ѯ ����ѯ�����������ܼ�¼��
		String countQueryString = " select count(*) "
				+ removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		int totalCount = ((Long) countlist.get(0)).intValue();

		if (totalCount < 1)
			return new DataPage();

		// ʵ�ʲ�ѯ���ط�ҳ����
		int startIndex = DataPage.getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new DataPage(startIndex, totalCount, pageSize, list);
	}

	/**
	 * ��ҳ��ѯ������ʹ��sql.
	 * 
	 * @param pageNo
	 *            ҳ��,��1��ʼ.
	 * @param pageSize
	 *            ÿҳ��¼��
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

		// Count��ѯ
		String countQueryString = " select count(*) "
				+ removeSelect(removeOrders(sql));

		int count = 0;

		List countList;
		// �����order ��order�� ���ڲ���;
		if (sql.indexOf("order") != -1
				&& (sql.substring(sql.indexOf("order")).indexOf("?")) != -1) {
			String sqlTemp = sql.substring(sql.indexOf("order"));
			// ���� order ��������ĸ���;
			while (sqlTemp.indexOf("?") >= 0) {
				sqlTemp = sqlTemp.substring(sqlTemp.indexOf("?") + 1);
				count++;
			}
			Object[] valuesCountParam = new Object[values.length - count];
			// ����select count(*)�Ĳ���;
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
		// ʵ�ʲ�ѯ���ط�ҳ����
		int startIndex = DataPage.getStartOfPage(pageNo, pageSize);
		SQLQuery sqlQuery = createSqlQuery(sql, values);
		List list = sqlQuery.setFirstResult(startIndex).setMaxResults(pageSize)
				.list();

		return new DataPage(startIndex, totalCount, pageSize, list);
	}

	/**
	 * getHibernateTemplate ���� sql��findby ����; pagedSqlQuery ����;
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
	 * ȥ��hql��select �Ӿ䣬δ����union�����,����pagedQuery. ����С�fetch������ȥ��
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
	 * ȥ��hql��orderby �Ӿ䣬����pagedQuery.
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
