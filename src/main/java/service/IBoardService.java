package service;

import java.util.List;

import model.BoardDto;

public interface IBoardService {
	boolean write(BoardDto dto);
	List<BoardDto> findAllPosts();
	BoardDto findPost(int articleNo);
	boolean updateBoard(BoardDto dto);
	boolean removeBoard(int articleNo);
}
