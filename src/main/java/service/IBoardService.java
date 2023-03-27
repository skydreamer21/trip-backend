package service;

import java.util.List;

import model.BoardDto;

public interface IBoardService {
	boolean write(BoardDto dto);
	List<BoardDto> findAllPosts();
}
