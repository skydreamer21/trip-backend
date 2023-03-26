package service;

import model.MemberDto;

public interface IMemberService {
	boolean registry(MemberDto dto);
	MemberDto login(MemberDto dto);
	boolean userCheck(MemberDto dto);
	boolean update(MemberDto dto);
	boolean resign(MemberDto dto);
}
