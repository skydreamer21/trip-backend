package model;

import java.util.List;

public interface iBoardDao {
	List<BoardDto> selectAllBoard();
	BoardDto selectByArticleNo(int articleNo);
	boolean insertBoard(BoardDto dto);
	boolean updateHitCount(int articleNo);
}
