package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;

public class MemberDaoImpl implements IMemberDao {

	DBUtil dbutil;

	// DB인스턴스받기
	public MemberDaoImpl() {
		dbutil = DBUtil.getInstance();
	}

	@Override
	public boolean insertUserInfo(MemberDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO members(user_id,user_name,user_password, ").append(" email_id,email_domain ) ")
				.append(" VALUES(?,?,?,?,?) ");
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = dbutil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, dto.getUser_name());
			psmt.setString(i++, dto.getUser_password());
			psmt.setString(i++, dto.getEmail_id());
			psmt.setString(i++, dto.getEmail_domain());

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("registry Exception:" + e);
		} finally {
			dbutil.close(psmt, conn);
		}

		return count > 0 ? true : false;
	}

	@Override
	public MemberDto selectUserInfo(MemberDto dto) {
		MemberDto login = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT user_id,user_name, email_id,email_domain  ");
		sql.append(" FROM members WHERE user_id=? and user_password=? ");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = dbutil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, dto.getUser_password());
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				login = new MemberDto(rs.getString(j++), rs.getString(j++), "", rs.getString(j++), rs.getString(j++));
			}

		} catch (SQLException e) {
			System.out.println("login Exception :" + e);
		} finally {
			dbutil.close(rs, psmt, conn);
		}
		return login;
	}
	
	public boolean updateUserInfo(MemberDto dto) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE members SET ")
		.append(" user_id=?, user_name=?, user_password=?, email_id=?, email_domain=? ")
		.append(" WHERE user_id=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = dbutil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setString(i++, dto.getUser_id());
			psmt.setString(i++, dto.getUser_name());
			psmt.setString(i++, dto.getUser_password());
			psmt.setString(i++, dto.getEmail_id());
			psmt.setString(i++, dto.getEmail_domain());

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update Exception:" + e);
		} finally {
			dbutil.close(psmt, conn);
		}

		return count > 0 ? true : false;
	}
	
	public boolean deleteUserInfo(MemberDto dto) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM members WHERE user_id=? ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		try {
			conn = dbutil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, dto.getUser_id());
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete Exception :" + e);
		} finally {
			dbutil.close(psmt, conn);
		}

		return count > 0 ? true : false;
	}
	
	

}
