package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import util.DBUtil;

public class BoardDaoImpl implements iBoardDao {
	DBUtil dbUtil;
	
	public BoardDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	@Override
	public List<BoardDto> selectAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDto selectByArticleNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBoard(BoardDto dto) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into board(user_id, title, content, hit, register_time) ")
			.append(" values(?, ?, ?, 0, now()) ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try {
			conn = dbUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i=1;
			psmt.setString(i++, dto.getUserId());
			psmt.setString(i++, dto.getTitle());
			psmt.setString(i++, dto.getContent());
			count = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[ERROR] mobile registry exceptions : " + e);
		} finally {
			dbUtil.close(psmt, conn);
		}
		return count > 0;
	}
}
