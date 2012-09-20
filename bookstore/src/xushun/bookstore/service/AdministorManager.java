package xushun.bookstore.service;

import xushun.bookstore.model.Administor;
import xushun.bookstore.util.DataPage;

public interface AdministorManager {
	
	/**
	 * ��ӹ���Ա
	 * @param admin
	 * @throws Exception
	 */
	public void addAdministor(Administor admin) throws Exception ;
	
	/**
	 * ͨ��Id��ȡ����Ա������������ڷ���null
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public Administor getAdministorById(Integer adminId) throws Exception ;

	/**
	 * ���¹���Ա����
	 * @param admin
	 * @throws Exception
	 */
	public void updateAdministor(Administor admin) throws Exception ;
	
	/**
	 * ͨ��Idɾ������Ա
	 * @param adminId
	 * @throws Exception
	 */
	public void removeAdministorById(Integer adminId) throws Exception ;
	
	/**
	 * ͨ����¼����ȡ����Ա����¼����Ψһ��
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public Administor getAdminstorByLoginName(String loginName) throws Exception ;
	
	/**
	 * ͨ����¼���������ȡ����Ա����������򷵻�null
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Administor getAdministorByLoginNameAndPassword(String loginName,String password) throws Exception ;
	
	/**
	 * �жϵ�¼���Ƿ����.<br>
	 * @param loginName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isLoginNameExists(String loginName) throws Exception;
	
	/**
	 * ����Ա��ҳ
	 * @return
	 * @throws Exception
	 */
	public DataPage<Administor> selectDataPageAdministors(Integer pageNo,Integer pageSize) throws Exception ;
	
	/**
	 * ͨ�����ֲ��ҹ���Ա
	 * @return
	 * @throws Exception
	 */
	public DataPage<Administor> selectDataPageAdministorsByName(String name,Integer pageNo,Integer pageSize) throws Exception ;
}
