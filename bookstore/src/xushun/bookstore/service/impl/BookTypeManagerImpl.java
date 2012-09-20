package xushun.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import xushun.bookstore.dao.impl.FirstTypeDaoHibernate;
import xushun.bookstore.dao.impl.SecondTypeDaoHibernate;
import xushun.bookstore.model.FirstType;
import xushun.bookstore.model.SecondType;
import xushun.bookstore.service.BookTypeManager;

public class BookTypeManagerImpl implements BookTypeManager {
	
	private FirstTypeDaoHibernate firstTypeDao;
	private SecondTypeDaoHibernate secondTypeDao;

	public boolean addFirstType(FirstType ft) throws Exception {
		// 是否以存在一级分类名
		boolean isFirstTypeExist = firstTypeDao.isTypeNameExists(ft.getTypeName());
		
		if(!isFirstTypeExist) {
			firstTypeDao.insert(ft);
			return true;
		}
		return false;
	}

	public boolean addSecondType(SecondType st) throws Exception {
		if(!isSubTypeNameExistsInFirstType(st.getSuperId(), st.getTypeName())) {
			secondTypeDao.insert(st);
			return true;
		}
		
		return false;
	}

	public FirstType getFirstTypeById(Integer ftId) throws Exception {
		return firstTypeDao.getById(ftId);
	}

	public FirstType getFirstTypeWithSubTypes(Integer ftId) throws Exception {
		return firstTypeDao.getFirstTypeWithSubTypes(ftId);
	}

	public SecondType getSecondTypeById(Integer stId) throws Exception {
		return secondTypeDao.getById(stId);
	}

	public SecondType getSecondTypeWithSuperType(Integer stId)
			throws Exception {
		return secondTypeDao.getSecondTypeWithSuperType(stId);
	}

	public List<SecondType> getSubTypesOfFirstType(Integer ftId)
			throws Exception {
		return firstTypeDao.getSubTypes(ftId);
	}

	public boolean isFirstTypeNameExists(String typeName) throws Exception {
		return firstTypeDao.isTypeNameExists(typeName);
	}

	public boolean isSubTypeNameExistsInFirstType(Integer ftId,
			String secondTypeName) throws Exception {
		
		List<SecondType> list = firstTypeDao.getSubTypes(ftId);
		
		if((list == null) || list.isEmpty())
			return false;
		
		for(SecondType st: list) {
			if(st.getTypeName().equals(secondTypeName))
				return true;
		}
		
		return false;
	}

	public boolean modifyFirstTypeName(Integer typeId, String typeName)
			throws Exception {
		if( !isFirstTypeNameExists(typeName)) {
			firstTypeDao.updateTypeName(typeId, typeName);
			return true;
		}
		
		return false;
	}

	public boolean modifySecondTypeName(Integer typeId, String typeName)
			throws Exception {
		SecondType st = secondTypeDao.getById(typeId);
		
		if(st == null)
			return false;
		
		if(!isSubTypeNameExistsInFirstType(st.getSuperId(), typeName)) {
			secondTypeDao.updateTypeName(typeId, typeName);
			return true;
		}
		
		return false;
	}

	// hai you que xian
	public void removeFirstType(Integer ftId) throws Exception {
		firstTypeDao.removeById(ftId);
	}

	public void removeSecondType(Integer stId) throws Exception {
		secondTypeDao.removeById(stId);
	}
	
	public List<FirstType> getAllFirstTypes() throws Exception {
		List<FirstType> list = firstTypeDao.getAll();
		
		if(list == null)
			return new ArrayList<FirstType>(0);
		
		for(FirstType ft:list) {
			ft.setSubTypes(firstTypeDao.getSubTypes(ft.getTypeId()));
		}
		return list;
	}
	
	public List<FirstType> getAllFirstTypesWithoutSubTypes() throws Exception {
		return firstTypeDao.getAllFirstTypesWithoutSubTypes();
	}

	public FirstTypeDaoHibernate getFirstTypeDao() {
		return firstTypeDao;
	}

	public void setFirstTypeDao(FirstTypeDaoHibernate firstTypeDao) {
		this.firstTypeDao = firstTypeDao;
	}

	public SecondTypeDaoHibernate getSecondTypeDao() {
		return secondTypeDao;
	}

	public void setSecondTypeDao(SecondTypeDaoHibernate secondTypeDao) {
		this.secondTypeDao = secondTypeDao;
	}
	
	public List<SecondType> getAllSecondTypes() throws Exception {
		return secondTypeDao.getAll();
	}

}
