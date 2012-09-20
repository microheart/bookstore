package xushun.bookstore.service.impl;

import xushun.bookstore.dao.impl.MemberDaoHibernate;
import xushun.bookstore.model.Member;
import xushun.bookstore.service.MemberManager;
import xushun.bookstore.util.DataPage;

public class MemberManagerImpl implements MemberManager {
	
	private MemberDaoHibernate memberDao;

	public void addMember(Member member) throws Exception {

		// ���û�Աע��ʱ�䣬���ϸ���ʱ��
		member.setRegisterTime(System.currentTimeMillis());
		member.setLastModifyTime(System.currentTimeMillis());
		
		memberDao.insert(member);
		
	}

	public Member getMemberById(Integer memberId) throws Exception {
		return memberDao.getById(memberId);
	}

	public Member getMemberByLoginName(String loginName) throws Exception {
		return memberDao.getMemberByLoginName(loginName);
	}
	
	public Member getMemberByLoginNameAndPassword(String loginName,
			String password) {
		return memberDao.getMemberByLoginNameAndPassword(loginName, password);
	}

	public boolean isLoginNameExists(String loginName) throws Exception {
		return memberDao.isLoginNameExits(loginName);
	}

	public boolean modifyPassword(Integer memberId, String oldPassword,
			String newPassword) throws Exception {
		
		// ���ݻ�ԱId��ѯ��Ա
		Member member = memberDao.getById(memberId);
		
		// �����Ա�����ڣ�����false
		if(member == null)
			return false;
		
		// �жϾ������Ƿ����
		if(member.getPassword().equals(oldPassword)) {
			memberDao.updateMemberPassword(memberId, newPassword);
			return true;
		}
			
		return false;
	}
	
	public DataPage<Member> selectDataPageMembers(Integer pageNo,
			Integer pageSize) throws Exception {
		return memberDao.selectDataPageMembers(pageNo, pageSize);
	}
	
	public DataPage<Member> selectDataPageMembersByName(String name,
			Integer pageNo, Integer pageSize) throws Exception {
		return memberDao.selectDataPageMembersByName(name, pageNo, pageSize);
	}

	public void removeMember(Integer memberId) throws Exception {
		memberDao.removeById(memberId);
	}

	public void updateMember(Member member) throws Exception {
		memberDao.update(member);
	}

	public MemberDaoHibernate getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDaoHibernate memberDao) {
		this.memberDao = memberDao;
	}

	
}
