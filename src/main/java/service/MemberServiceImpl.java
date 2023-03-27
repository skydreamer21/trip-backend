package service;

import model.IMemberDao;
import model.MemberDaoImpl;
import model.MemberDto;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDao mdao;

	private static  IMemberService mservice=new MemberServiceImpl();
	
	private MemberServiceImpl() {
		mdao=new MemberDaoImpl();
	}
	
	public static IMemberService getInstance() {
		return mservice;
	}
	
	@Override
	public boolean registry(MemberDto dto) {
		if (userCheck(dto)) {
			return mdao.insertUserInfo(dto);	
		}
		return false;
		
	}

	@Override
	public MemberDto login(MemberDto dto) {
		
		MemberDto loginUser = mdao.selectUserInfo(dto);
		if(loginUser != null) {
			return loginUser;
		}
		
		return null;

	}
		
	@Override
	public boolean userCheck(MemberDto dto) {
		
		if(mdao.selectUserInfo(dto) != null) {
			return false;
		}
		return true;
		
	}
	
	public boolean update(MemberDto dto) {
		return mdao.updateUserInfo(dto);
	}
	
	public boolean resign(MemberDto dto) {
		return mdao.deleteUserInfo(dto);
	}

}
