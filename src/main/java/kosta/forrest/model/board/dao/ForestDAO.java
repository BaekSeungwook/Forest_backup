package kosta.forrest.model.board.dao;

import java.util.List;

import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestDAO{

	/**
	 * 휴양림정보 전체목록
	 * */
	List<ForestDTO> selectAll() ;

	/**
	 * 휴양림정보 상세보기
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * 휴양림정보 키워드검색
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * 휴양림정보 등록
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * 휴양림정보 삭제
	 * */
	int delete(int forestNo);

	/**
	 * 휴양림정보 수정
	 * */
	int update(ForestDTO forestDTO);

}
