package model;

import java.util.List;

public interface iAtrractionDao {
	List<AttractionDto> selectAttractions(int sidoCode, int gugunCode, int contentTypeId, String keyword, 
			int offset, int itemCount);
	
}
