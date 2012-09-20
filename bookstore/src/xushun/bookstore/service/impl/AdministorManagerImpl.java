package xushun.bookstore.service.impl;

import xushun.bookstore.dao.impl.AdministorDaoHibernate;
import xushun.bookstore.model.Administor;
import xushun.bookstore.service.AdministorManager;
import xushun.bookstore.util.DataPage;

public class AdministorManagerImpl implements AdministorManager {

	private AdministorDaoHibernate adminDao;
	
	public void addAdministor(Administor admin) throws Exception {
		adminDao.insert(admin);
	}

	public Administor getAdministorById(Integer adminId) throws Exception {
		return adminDao.getById(adminId);
	}

	public Administor getAdministorByLoginNameAndPassword(String loginName,
			String password) throws Exception {
		return adminDao.getAdministorByLoginNameAndPassword(loginName, password);
	}

	public Administor getAdminstorByLoginName(String loginName)
			throws Exception {
		return adminDao.getAdministorByLoginName(loginName);
	}

	public boolean isLoginNameExists(String loginName) throws Exception {
		return adminDao.isLoginNameExits(loginName);
	}

	public void removeAdministorById(Integer adminId) throws Exception {
		adminDao.removeById(adminId);
	}

	public DataPage<Administor> selectDataPageAdministors(Integer pageNo,Integer pageSize) throws Exception {
		return adminDao.selectDataPageAdministors(pageNo, pageSize);
	}

	public DataPage<Administor> selectDataPageAdministorsByName(String name,Integer pageNo,Integer pageSize)
			throws Exception {
		return adminDao.selectDataPageAdministorsByName(name, pageNo, pageSize);
	}

	public void updateAdministor(Administor admin) throws Exception {
		adminDao.update(admin);
	}

	public AdministorDaoHibernate getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdministorDaoHibernate adminDao) {
		this.adminDao = adminDao;
	}
	
	

}
