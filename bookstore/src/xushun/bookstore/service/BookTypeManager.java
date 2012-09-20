package xushun.bookstore.service;

import java.util.List;

import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;


public interface BookTypeManager {
	
	/**
	 * 通过Id获取一级分类
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public FirstType getFirstTypeById(Integer ftId) throws Exception ;
	
	/**
	 * 通过Id获取一级分类，并取得它的子类别
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public FirstType getFirstTypeWithSubTypes(Integer ftId) throws Exception ;
	
	/**
	 * 通过Id获取二级分类
	 * @param stId
	 * @return
	 * @throws Exception
	 */
	public SecondType getSecondTypeById(Integer stId) throws Exception ;
	
	/**
	 * 通过Id取得二级分类并同时获得其上级分类
	 * @param sstId
	 * @return
	 * @throws Exception
	 */
	public SecondType getSecondTypeWithSuperType(Integer stId) throws Exception ;
	
	/**
	 * 根据一级分类Id删除对应的一级分类
	 * @param ftId
	 * @throws Exception
	 */
	public void removeFirstType(Integer ftId) throws Exception ;
	
	/**
	 * 根据二级分类Id删除对应的二级分类
	 * @param stId
	 * @throws Exception
	 */
	public void removeSecondType(Integer stId) throws Exception ;
	
	/**
	 * 添加一级分类，在添加时需判断是否一级存在相同的分类名了，如果存在，则返回false
	 * @param ft
	 * @return 
	 * @throws Exception
	 */
	public boolean addFirstType(FirstType ft) throws Exception ;
	
	/**
	 * 添加二级分类，需判断在在与它同一目录下是否存在相同的分类名
	 * @param st
	 * @return
	 * @throws Exception
	 */
	public boolean addSecondType(SecondType st) throws Exception ;
	
	/**
	 * 修改一级分类名
	 * @param typeId
	 * @param typeName
	 * @throws Exception
	 */
	public boolean modifyFirstTypeName(Integer typeId, String typeName) throws Exception ;
	
	/**
	 * 修改二级分类名
	 * @param typeId
	 * @param typeName
	 * @throws Exception
	 */
	public boolean modifySecondTypeName(Integer typeId, String typeName) throws Exception ;
	
	/**
	 * 判断是否存在对应的一级分类名
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public boolean isFirstTypeNameExists(String typeName) throws Exception;
	
	/**
	 * 判断在制定的一级分类下，是否存在对应的二级分类名
	 * @param ftId
	 * @param secondTypeName
	 * @return
	 * @throws Exception
	 */
	public boolean isSubTypeNameExistsInFirstType(Integer ftId,String secondTypeName) throws Exception ;
	
	/**
	 * 获取一级分类下全部子分类
	 * @param ftId
	 * @return
	 * @throws Exception
	 */
	public List<SecondType> getSubTypesOfFirstType(Integer ftId) throws Exception ;
	
	/**
	 * 获取所有一级分类并有它的包含它的全部子分类
	 * @return
	 * @throws Exception
	 */
	public List<FirstType> getAllFirstTypes() throws Exception ;
	
	/**
	 * 取得所有一级分类，但不包括其子类别
	 * @return
	 */
	public List<FirstType> getAllFirstTypesWithoutSubTypes() throws Exception;
	
	/**
	 * 取得所有二级分类
	 * @return
	 * @throws Exception
	 */
	public List<SecondType> getAllSecondTypes() throws Exception;
}
