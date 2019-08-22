package kosta.forrest.model.board.dao;

import java.util.List;

import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestDAO{

	/**
	 * �޾縲���� ��ü���
	 * */
	List<ForestDTO> selectAll() ;

	/**
	 * �޾縲���� �󼼺���
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * �޾縲���� Ű����˻�
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * �޾縲���� ���
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * �޾縲���� ����
	 * */
	int delete(int forestNo);

	/**
	 * �޾縲���� ����
	 * */
	int update(ForestDTO forestDTO);

}
