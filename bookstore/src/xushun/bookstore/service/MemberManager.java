package xushun.bookstore.service;

import xushun.bookstore.model.Member;
import xushun.bookstore.util.DataPage;

/**
 * 会员管理
 * @author xushun
 *
 */
public interface MemberManager {
	
	/**
	 * 添加会员
	 * @param member
	 * @throws Exception
	 */
	public void addMember(Member member) throws Exception ;

	/**
	 * 更新会员资料
	 * @param member
	 * @throws Exception
	 */
	public void updateMember(Member member) throws Exception ;
	
	/**
	 * 通过会员Id删除会员
	 * @param memberId
	 * @throws Exception
	 */
	public void removeMember(Integer memberId) throws Exception ;
	
	/**
	 * 根据会员Id查询会员，如果没有则返回空
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public Member getMemberById(Integer memberId) throws Exception ;
	
	
	/**
	 * 通过登录名查询会员，如果不存在则返回空
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public Member getMemberByLoginName(String loginName) throws Exception ;
	
	/**
	 * 通过登录名和密码取得会员
	 * @param loginName
	 * @param password
	 * @return
	 */
	public Member getMemberByLoginNameAndPassword(String loginName,String password) ;
	
	/**
	 * 修改会员密码.<br>
	 * <br>
	 * <font color="red">
	 * 情况1：会员输入旧密码错误，返回false ;<br>
	 * 情况2：会员输入正确，修改成功，返回true;<br>
	 * 情况3：由于传入的会员标识错误，或者数据库操作中出现问题，抛出异常;<br>
	 * </font>
	 * @param memberId
	 * @param oldPassword
	 * @param newPassword
	 * @return boolean
	 * @throws Exception
	 */
	public boolean modifyPassword(Integer memberId, String oldPassword, String newPassword) throws Exception;
	
	/**
	 * 判断登录名是否存在.<br>
	 * @param loginName
	 * @return boolean
	 * @throws Exception
	 */
	boolean isLoginNameExists(String loginName) throws Exception;
	
	/**
	 * 会员分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public DataPage<Member> selectDataPageMembers(Integer pageNo,Integer pageSize) throws Exception;
	
	/**
	 * 通过名字查找会员
	 * @param name
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public DataPage<Member> selectDataPageMembersByName(String name,Integer pageNo,Integer pageSize) throws Exception ;
}
