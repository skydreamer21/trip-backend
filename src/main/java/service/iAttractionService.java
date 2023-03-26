package service;

import java.util.List;

import model.GugunDto;
import model.SidoDto;

public interface iAttractionService {
	List<SidoDto> readSido();
	List<GugunDto> findGugunBySido(int sidoCode);
}
