package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.constant.AttractionListConstant;
import util.DBUtil;

public class AttractionDaoImpl implements iAtrractionDao {
	DBUtil dbUtil;

	public AttractionDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	@Override
	public List<AttractionDto> selectAttractions(int sidoCode, int gugunCode, int contentTypeId, String keyword, 
			int offset, int itemCount) {
		List<AttractionDto> attractionDtos = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select content_id, content_type_id, title, addr1, tel, first_image, ")
			.append(" readcount, latitude, longitude from attraction_info ")
			.append(" where sido_code=? ");
		if(gugunCode != 0) {
			sql.append(" and gugun_code=? ");
		}
		if(contentTypeId != 0) {
			sql.append(" and content_type_id=? ");
		}
		if(!keyword.trim().equals("")) {
			sql.append( " and title like ? ");
		}
		sql.append("limit ?, ?");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			psmt = conn.prepareStatement(sql.toString());
			int i = 1;
			psmt.setInt(i++, sidoCode);
			if(gugunCode != 0) {
				psmt.setInt(i++, gugunCode);
			}
			if(contentTypeId != 0) {
				psmt.setInt(i++, contentTypeId);
			}
			if(!keyword.trim().equals("")) {
				psmt.setString(i++, "%" + keyword + "%");
			}
			psmt.setInt(i++, offset);
			psmt.setInt(i++, itemCount);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				int j = 1;
				AttractionDto dto = new AttractionDto(
						rs.getInt(j++), 
						rs.getInt(j++), 
						rs.getString(j++),
						rs.getString(j++),
						rs.getString(j++),
						rs.getString(j++),
						rs.getInt(j++),
						rs.getInt(j++),
						rs.getInt(j++));
				attractionDtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("[ERROR] attraction exception : " + e);
		} finally {
			dbUtil.close(rs, psmt, conn);
		}
		return attractionDtos;
	}

}
