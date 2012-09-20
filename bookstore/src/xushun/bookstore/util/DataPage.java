package xushun.bookstore.util ;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ����. ������ǰҳ���ݼ���ҳ��Ϣ���ܼ�¼��.
 *
 * @author xijia
 */
@SuppressWarnings("serial")
public class DataPage<T> implements Serializable {

	private static int DEFAULT_PAGE_SIZE = 10;

	private int pageSize = DEFAULT_PAGE_SIZE; // ÿҳ�ļ�¼��

	private int start; // ��ǰҳ��һ��������List�е�λ��,��0��ʼ

	private List<T> data; // ��ǰҳ�д�ŵļ�¼,����һ��ΪList

	private int totalCount; // �ܼ�¼��

	/**
	 * ���췽����ֻ�����ҳ.
	 */
	public DataPage() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}

	/**
	 * Ĭ�Ϲ��췽��.
	 *
	 * @param start	 ��ҳ���������ݿ��е���ʼλ��
	 * @param totalSize ���ݿ����ܼ�¼����
	 * @param pageSize  ��ҳ����
	 * @param data	  ��ҳ����������
	 */
	public DataPage(int start, int totalSize, int pageSize, List<T> data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * ȡ�ܼ�¼��.
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * ȡ��ҳ��.
	 */
	public int getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	/**
	 * ȡÿҳ��������.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ȡ��ǰҳ�еļ�¼.
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * ȡ��ҳ��ǰҳ��,ҳ���1��ʼ.
	 */
	public int getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * ��ҳ�Ƿ�����һҳ.
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount() ;
	}

	/**
	 * ��ҳ�Ƿ�����һҳ.
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	/**
	 * ��ȡ��һҳ��һ�����������ݼ���λ�ã�ÿҳ����ʹ��Ĭ��ֵ.
	 *
	 * @see #getStartOfPage(int,int)
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	/**
	 * ��ȡ��һҳ��һ�����������ݼ���λ��.
	 *
	 * @param pageNo   ��1��ʼ��ҳ��
	 * @param pageSize ÿҳ��¼����
	 * @return ��ҳ��һ������
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	public void setData(List<T> data)
	{
		this.data = data;
	}

	public int getStart()
	{
		return start;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
	
}