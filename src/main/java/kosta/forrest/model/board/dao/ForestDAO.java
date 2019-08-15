package kosta.forrest.model.board.dao;

import java.util.List;

import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestDAO{

	/**
	 * ?��코드 ?���? �??��
	 * */
	List<ForestDTO> selectAll() ;

	/**
	 * 모델번호?�� ?��?��?��?�� ?��코드 �??��
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * ?��?��림이�?, 주소�? �??��
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * ?��코드 ?��?��
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * 모델번호?�� ?��?��?��?�� ?��코드 ?��?��
	 * */
	int delete(int forestNo);

	/**
	 * 모델번호?�� ?��?��?��?�� ?��코드 ?��?��
	 * */
	int update(ForestDTO forestDTO);

}
