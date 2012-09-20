package xushun.bookstore.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Generics��util��.
 *
 * @author xushun
 */
public class GenericsUtils {

	private GenericsUtils() {
	}

	/**
	 * ͨ������,��ö���Classʱ�����ĸ���ķ��Ͳ���������. ��public BookManager extends GenricManager<Book>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * ͨ������,��ö���Classʱ�����ĸ���ķ��Ͳ���������. ��public BookManager extends GenricManager<Book>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic declaration,start from 0.
	 * @return the index generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();
		/*�ж��Ƿ�̳��Դ���*/
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		/*�жϴ��Ĳ�����index �Ƿ�Ϸ�*/
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		/*�ж��Ƿ������������ͣ���Ϊ������ �������� T */
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
}
