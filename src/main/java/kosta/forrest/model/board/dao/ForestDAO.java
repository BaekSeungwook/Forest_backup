package kosta.forrest.model.board.dao;

import java.util.List;

import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestDAO{

	/**
	 * ? ˆì½”ë“œ ? „ì²? ê²??ƒ‰
	 * */
	List<ForestDTO> selectAll() ;

	/**
	 * ëª¨ë¸ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ? ˆì½”ë“œ ê²??ƒ‰
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * ?œ´?–‘ë¦¼ì´ë¦?, ì£¼ì†Œë³? ê²??ƒ‰
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * ? ˆì½”ë“œ ?‚½?…
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * ëª¨ë¸ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ? ˆì½”ë“œ ?‚­? œ
	 * */
	int delete(int forestNo);

	/**
	 * ëª¨ë¸ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ? ˆì½”ë“œ ?ˆ˜? •
	 * */
	int update(ForestDTO forestDTO);

}
