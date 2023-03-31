package service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	@Override
	public List<BoardDto> findAllPosts() {
		List<BoardDto> boardList = dao.selectAllBoard();
		Collections.sort(boardList, new Comparator<BoardDto>() {
			@Override
			public int compare(BoardDto b1, BoardDto b2) {
				if (b1.getIsAnnouncement() ^ b2.getIsAnnouncement()) { // 다르면
					if(b1.getIsAnnouncement()) {
						return -1;
					} else {
						return 1;
					}
				} else {
					return b2.getRegisterTime().compareTo(b1.getRegisterTime());
				}
			}
		});
		return boardList;
	}

	@Override
	public BoardDto findPost(int articleNo) {
		// TODO : 유효성 검증
		
		// TODO : 조회수 올리기
		dao.updateHitCount(articleNo);
		
		return dao.selectByArticleNo(articleNo);
	}

	@Override
	public boolean updateBoard(BoardDto dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public boolean removeBoard(int articleNo) {
		return dao.deleteBoard(articleNo);
	}
	
	
}
