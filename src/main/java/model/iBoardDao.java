package model;

import java.util.List;

public interface iBoardDao {
	List<BoardDto> selectAllBoard();
	BoardDto selectByArticleNo();
	boolean insertBoard(BoardDto dto);
}
