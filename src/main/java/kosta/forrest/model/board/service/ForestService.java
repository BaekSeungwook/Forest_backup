package kosta.forrest.model.board.service;

import java.util.List;

import kosta.forrest.model.board.dto.Criteria;
import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestService {
	/**
	 * 레코드 전체 검색
	 * */
	List<ForestDTO> selectAll(Criteria cri) ;

	/**
	 * 휴양림번호에 해당하는 레코드 검색
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * 휴양림이름, 주소별 검색
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * 레코드 삽입
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * 휴양림번호에 해당하는 레코드 삭제
	 * */
	int delete(int forestNo);

	/**
	 * 휴양림번호에 해당하는 레코드 수정
	 * */
	int update(ForestDTO forestDTO);
}
