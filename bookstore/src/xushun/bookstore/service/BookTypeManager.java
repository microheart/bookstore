package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;


public interface BookTypeManager {
	
	/**
	 * ͨ��Id��ȡһ������
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public FirstType getFirstTypeById(Integer ftId) throws Exception ;
	
	/**
	 * ͨ��Id��ȡһ�����࣬��ȡ�����������
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public FirstType getFirstTypeWithSubTypes(Integer ftId) throws Exception ;
	
	/**
	 * ͨ��Id��ȡ��������
	 * @param stId
	 * @return
	 * @throws Exception
	 */
	public SecondType getSecondTypeById(Integer stId) throws Exception ;
	
	/**
	 * ͨ��Idȡ�ö������ಢͬʱ������ϼ�����
	 * @param sstId
	 * @return
	 * @throws Exception
	 */
	public SecondType getSecondTypeWithSuperType(Integer stId) throws Exception ;
	
	/**
	 * ����һ������Idɾ����Ӧ��һ������
	 * @param ftId
	 * @throws Exception
	 */
	public void removeFirstType(Integer ftId) throws Exception ;
	
	/**
	 * ���ݶ�������Idɾ����Ӧ�Ķ�������
	 * @param stId
	 * @throws Exception
	 */
	public void removeSecondType(Integer stId) throws Exception ;
	
	/**
	 * ���һ�����࣬�����ʱ���ж��Ƿ�һ��������ͬ�ķ������ˣ�������ڣ��򷵻�false
	 * @param ft
	 * @return 
	 * @throws Exception
	 */
	public boolean addFirstType(FirstType ft) throws Exception ;
	
	/**
	 * ��Ӷ������࣬���ж���������ͬһĿ¼���Ƿ������ͬ�ķ�����
	 * @param st
	 * @return
	 * @throws Exception
	 */
	public boolean addSecondType(SecondType st) throws Exception ;
	
	/**
	 * �޸�һ��������
	 * @param typeId
	 * @param typeName
	 * @throws Exception
	 */
	public boolean modifyFirstTypeName(Integer typeId, String typeName) throws Exception ;
	
	/**
	 * �޸Ķ���������
	 * @param typeId
	 * @param typeName
	 * @throws Exception
	 */
	public boolean modifySecondTypeName(Integer typeId, String typeName) throws Exception ;
	
	/**
	 * �ж��Ƿ���ڶ�Ӧ��һ��������
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public boolean isFirstTypeNameExists(String typeName) throws Exception;
	
	/**
	 * �ж����ƶ���һ�������£��Ƿ���ڶ�Ӧ�Ķ���������
	 * @param ftId
	 * @param secondTypeName
	 * @return
	 * @throws Exception
	 */
	public boolean isSubTypeNameExistsInFirstType(Integer ftId,String secondTypeName) throws Exception ;
	
	/**
	 * ��ȡһ��������ȫ���ӷ���
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public List<SecondType> getSubTypesOfFirstType(Integer ftId) throws Exception ;
	
	/**
	 * ��ȡ����һ�����ಢ�����İ�������ȫ���ӷ���
	 * @return
	 * @throws Exception
	 */
	public List<FirstType> getAllFirstTypes() throws Exception ;
	
	/**
	 * ȡ������һ�����࣬���������������
	 * @return
	 */
	public List<FirstType> getAllFirstTypesWithoutSubTypes() throws Exception;
	
	/**
	 * ȡ�����ж�������
	 * @return
	 * @throws Exception
	 */
	public List<SecondType> getAllSecondTypes() throws Exception;
}
