package kosta.forrest.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.forrest.model.board.dao.LodgeDAO;
import kosta.forrest.model.board.dto.LodgeDTO;

@Service
public class LodgeServiceImpl implements LodgeService {

	@Autowired
	private LodgeDAO lodgeDAO;
	
	@Override
	public List<LodgeDTO> selectAll(int forestNo) {
		//System.out.println("LodgeServiceImpl¿« selectAll");
		List<LodgeDTO> list = lodgeDAO.selectAll(forestNo);
		return list;
	}

	@Override
	public int insert(LodgeDTO §”odgeDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String lodeCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(LodgeDTO LodgeDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
