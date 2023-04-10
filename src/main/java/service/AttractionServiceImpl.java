package service;

import java.util.List;

import model.AttractionDaoImpl;
import model.AttractionDto;
import model.GugunDaoImpl;
import model.GugunDto;
import model.PageNav;
import model.SidoDaoImpl;
import model.SidoDto;
import service.constant.AttractionListConstant;

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
	public List<AttractionDto> findAttractions(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo) {
		int offset = (pageNo-1) * AttractionListConstant.ITEM_COUNT.getValue();
		return attractionDao.selectAttractions(
				sidoCode, gugunCode, contentTypeId, keyword, 
				offset, AttractionListConstant.ITEM_COUNT.getValue());
	}

	@Override
	public PageNav findPageNavInfo(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo) {
		int order = pageNo % AttractionListConstant.PAGE_COUNT.getValue();
		order = order == 0 ? AttractionListConstant.PAGE_COUNT.getValue() : order;
		int maxAttractionCountFromStartPage = order * AttractionListConstant.ITEM_COUNT.getValue();
		
		int startPage = pageNo - order + 1;
		int attractionCount = findAttractionCountByPageNo(
				sidoCode, gugunCode, contentTypeId, keyword,
				startPage, 
				AttractionListConstant.PAGE_COUNT.getValue() + 1);
		int itemCount = attractionCount >= maxAttractionCountFromStartPage ? 
				AttractionListConstant.ITEM_COUNT.getValue() : attractionCount % AttractionListConstant.ITEM_COUNT.getValue();
		int pageCount = AttractionListConstant.PAGE_COUNT.getValue();
		
		boolean hasNextNav = true;
		if (attractionCount < AttractionListConstant.getTotalItemCountInNav()) {
			pageCount = attractionCount / AttractionListConstant.ITEM_COUNT.getValue() + 1;
			if (attractionCount % AttractionListConstant.ITEM_COUNT.getValue() == 0) {
				pageCount--;
			}
			hasNextNav = false;
		}
		
		boolean hasPrevNav = pageNo > AttractionListConstant.PAGE_COUNT.getValue();
		
		return new PageNav(pageCount, itemCount, startPage, pageNo, hasPrevNav, hasNextNav);
	}

	private int findAttractionCountByPageNo(int sidoCode, int gugunCode, int contentTypeId, String keyword, 
			int startPage, int numberOfPages) {
		int offset = (startPage-1) * AttractionListConstant.ITEM_COUNT.getValue();
		int maxCount = numberOfPages * AttractionListConstant.ITEM_COUNT.getValue();
		return attractionDao.selectCountByPageNo(sidoCode, gugunCode, contentTypeId, keyword, offset, maxCount);
	}
	
	
	
}
