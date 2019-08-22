package kosta.forrest.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.forrest.model.board.dao.ForestDAO;
import kosta.forrest.model.board.dto.ForestDTO;

@Service
public class ForestServiceImpl implements ForestService {

	@Autowired
	private ForestDAO forestDAO;
	
	@Override
	public List<ForestDTO> selectAll() {
		List<ForestDTO> list = forestDAO.selectAll();
		return list;
	}

	@Override
	public ForestDTO selectByForestNo(int forestNo) {
		ForestDTO forestDTO = forestDAO.selectByForestNo(forestNo);
		return forestDTO;
	}

	@Override
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) {
		List<ForestDTO> list = forestDAO.selectBySearch(keyWord, keyField);
		return list;
	}

	@Override
	public int insert(ForestDTO forestDTO) {
		int result = forestDAO.insert(forestDTO);
		if(result==0) throw new RuntimeException("등록되지 않았습니다.");
		return result;
	}

	@Override
	public int delete(int forestNo) {
		int result = forestDAO.delete(forestNo);
		if(result==0) throw new RuntimeException("삭제되지 않았습니다.");
		return result;
	}

	@Override
	public int update(ForestDTO forestDTO) {
		int result = forestDAO.update(forestDTO);
		if(result==0) throw new RuntimeException("수정되지 않았습니다.");
		return result;
	}

}
