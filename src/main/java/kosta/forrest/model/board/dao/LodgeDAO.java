package kosta.forrest.model.board.dao;

import java.util.List;

import kosta.forrest.model.board.dto.ForestDTO;
import kosta.forrest.model.board.dto.LodgeDTO;

public interface LodgeDAO{

	List<LodgeDTO> selectAll(int forestNo) ;

	int insert(LodgeDTO lodgeDTO);

	int delete(String LodgeCode);

	int update(LodgeDTO lodgeDTO);
}
