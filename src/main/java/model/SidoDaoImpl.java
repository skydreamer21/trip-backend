package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class SidoDaoImpl implements iSidoDao {
	DBUtil dbUtil;
	
	public SidoDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public List<SidoDto> selectSido() {
		List<SidoDto> sidos = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from sido ");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dbUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				int j=1;
				SidoDto dto = new SidoDto(rs.getInt(j++), rs.getString(j++));
				sidos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] sido exception : " + e);
		} finally {
			dbUtil.close(rs, psmt, conn);
		}
		return sidos;
	}
}
