package service;

import java.util.List;

import model.SidoDaoImpl;
import model.SidoDto;

public class AttractionServiceImpl implements iAttractionService {
	private static AttractionServiceImpl instance = new AttractionServiceImpl();
	private  SidoDaoImpl dao;

	private AttractionServiceImpl() {
		dao = new SidoDaoImpl();
	}
	
	public static AttractionServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<SidoDto> readSido() {
		return dao.selectSido();
	}
}
