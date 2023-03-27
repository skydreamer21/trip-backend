package service;

import model.BoardDaoImpl;
import model.BoardDto;

public class BoardServiceImpl implements IBoardService {
	private static BoardServiceImpl instance = new BoardServiceImpl();
	private BoardDaoImpl dao;
	
	private BoardServiceImpl() {
		dao = new BoardDaoImpl();
	}
	
	public static BoardServiceImpl getInstance() {
		return instance;
	}

	@Override
	public boolean write(BoardDto dto) {
		return dao.insertBoard(dto);
	}
	
	
}
