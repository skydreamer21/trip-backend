package model;

public interface IMemberDao {
	boolean insertUserInfo(MemberDto dto); // 유저 생성   
	MemberDto selectUserInfo(MemberDto dto); // 유저 검색
	boolean updateUserInfo(MemberDto dto); // 유저 정보 수정 
	boolean deleteUserInfo(MemberDto dto); // 유저 삭제
	
}
