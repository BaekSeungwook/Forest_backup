package kosta.forrest.model.board.service;

import java.util.List;

import kosta.forrest.model.board.dto.Criteria;
import kosta.forrest.model.board.dto.ForestDTO;

public interface ForestService {
	/**
	 * ���ڵ� ��ü �˻�
	 * */
	List<ForestDTO> selectAll(Criteria cri) ;

	/**
	 * �޾縲��ȣ�� �ش��ϴ� ���ڵ� �˻�
	 * */
	ForestDTO selectByForestNo(int forestNo) ;
	
	/**
	 * �޾縲�̸�, �ּҺ� �˻�
	 * */
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) ;

	/**
	 * ���ڵ� ����
	 * */
	int insert(ForestDTO forestDTO);

	/**
	 * �޾縲��ȣ�� �ش��ϴ� ���ڵ� ����
	 * */
	int delete(int forestNo);

	/**
	 * �޾縲��ȣ�� �ش��ϴ� ���ڵ� ����
	 * */
	int update(ForestDTO forestDTO);
}
