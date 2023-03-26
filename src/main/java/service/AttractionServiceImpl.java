package service;

import java.util.List;

import model.GugunDaoImpl;
import model.GugunDto;
import model.SidoDaoImpl;
import model.SidoDto;

public class AttractionServiceImpl implements iAttractionService {
	private static AttractionServiceImpl instance = new AttractionServiceImpl();
	private  SidoDaoImpl sidoDao;
	private GugunDaoImpl gugunDao;

	private AttractionServiceImpl() {
		sidoDao = new SidoDaoImpl();
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
	
	
}
