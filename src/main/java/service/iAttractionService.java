package service;

import java.util.List;

import model.AttractionDto;
import model.GugunDto;
import model.PageNav;
import model.SidoDto;

public interface iAttractionService {
	List<SidoDto> readSido();
	List<GugunDto> findGugunBySido(int sidoCode);
	List<AttractionDto> findAttractions(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo);
	PageNav findPageNavInfo(int sidoCode, int gugunCode, int contentTypeId, String keyword, int pageNo);
}
