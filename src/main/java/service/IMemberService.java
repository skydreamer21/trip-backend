package service;

import java.util.List;

import model.MemberDto;

public interface IMemberService {
	boolean registry(MemberDto dto);
	MemberDto login(MemberDto dto);
	boolean userCheck(MemberDto dto);
	boolean update(MemberDto dto);
	boolean resign(MemberDto dto);
	List<MemberDto> findAllMembers();
	MemberDto findMemberById(String user_id);
}
