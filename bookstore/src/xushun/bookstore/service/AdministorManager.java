package xushun.bookstore.service;

import xushun.bookstore.model.Administor;
import xushun.bookstore.util.DataPage;

public interface AdministorManager {
	
	/**
	 * 添加管理员
	 * @param admin
	 * @throws Exception
	 */
	public void addAdministor(Administor admin) throws Exception ;
	
	/**
	 * 通过Id获取管理员对象，如果不存在返回null
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public Administor getAdministorById(Integer adminId) throws Exception ;

	/**
	 * 更新管理员资料
	 * @param admin
	 * @throws Exception
	 */
	public void updateAdministor(Administor admin) throws Exception ;
	
	/**
	 * 通过Id删除管理员
	 * @param adminId
	 * @throws Exception
	 */
	public void removeAdministorById(Integer adminId) throws Exception ;
	
	/**
	 * 通过登录名获取管理员，登录名是唯一的
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public Administor getAdminstorByLoginName(String loginName) throws Exception ;
	
	/**
	 * 通过登录名和密码获取管理员，如果不存则返回null
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Administor getAdministorByLoginNameAndPassword(String loginName,String password) throws Exception ;
	
	/**
	 * 判断登录名是否存在.<br>
	 * @param loginName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isLoginNameExists(String loginName) throws Exception;
	
	/**
	 * 管理员分页
	 * @return
	 * @throws Exception
	 */
	public DataPage<Administor> selectDataPageAdministors(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * 通过名字查找管理员
	 * @return
	 * @throws Exception
	 */
	public DataPage<Administor> selectDataPageAdministorsByName(String name,Integer pageNo,Integer pageSize) throws Exception ;
}
