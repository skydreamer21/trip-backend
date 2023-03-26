package service;

import java.util.List;

import model.AttractionDaoImpl;
import model.AttractionDto;
import model.GugunDaoImpl;
import model.GugunDto;
import model.SidoDaoImpl;
import model.SidoDto;

public class AttractionServiceImpl implements iAttractionService {
	private static AttractionServiceImpl instance = new AttractionServiceImpl();
	private  SidoDaoImpl sidoDao;
	private GugunDaoImpl gugunDao;
	private AttractionDaoImpl attractionDao;

	private AttractionServiceImpl() {
		sidoDao = new SidoDaoImpl();
		gugunDao = new GugunDaoImpl();
		attractionDao = new AttractionDaoImpl();
	}
	
	public static AttractionServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<SidoDto> readSido() {
		return sidoDao.selectSido();
	}

	@Override
	public List<GugunDto> findGugunBySido(int sidoCode) {
		return gugunDao.selectGugunBySido(sidoCode);
	}

	@Override
	public List<AttractionDto> findAttractions(int sidoCode, int gugunCode, int contentTypeId, String keyword) {
		return attractionDao.selectAttractions(sidoCode, gugunCode, contentTypeId, keyword);
	}
	
}
