package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class GugunDaoImpl implements iGungunDao {
	DBUtil dbUtil;

	public GugunDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	@Override
	public List<GugunDto> selectGugunBySido(int sidoCode) {
		List<GugunDto> guguns = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from gugun ")
			.append(" where sido_code=? ");

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, sidoCode);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				GugunDto dto = new GugunDto(rs.getInt(j++), rs.getString(j++), rs.getInt(j++));
				guguns.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] gugun exception : " + e);
		} finally {
			dbUtil.close(rs, psmt, conn);
		}
		return guguns;
	}

}
