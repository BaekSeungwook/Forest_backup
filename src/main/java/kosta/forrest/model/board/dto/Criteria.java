package kosta.forrest.model.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *  - ���� �������� �����͸� ���� ���� ���� ����
 *  ������, ���������� ǥ���� �������� ����, ���� �� ��ȣ, �� �� ��ȣ
 *  
 *  - ȭ�鿡 ������ ������ ��ȣ
 *  �� �������� ����, �� �������� ����
 *  ���������� ǥ���� ������ ��ȣ�� ����, ����������, ��������
 *  ���� ������ ����, ���� �������� ����
 */

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Criteria {

	// DB���� ������ ó���� �����͸� ���� ���µ� �ʿ��� ����.
	private int page, perPageNum, startRow, endRow;
	
	// JSP���� �ϴ� �κ��� ������ ǥ�� �κп� �ʿ��� ����
	private int totalCount, totalPage, displayPageNum, startPage, endPage;
	
	private boolean prev, next;
	
	// �˻��� ���� ������� �߰�
	private String searchType; // �˻� �׸� �̸�
	private String keyword; // �˻��ϴ� ���ڿ�

	// ��ó�� �����Ҷ� list.do�� �����ϹǷ� �������� 1, �� �������� ǥ���� �������� ���� 10���� ���Ѵ�.
	// �⺻ ������(�Ķ���Ͱ� ���� ������)�� �̿��ؼ� ���� ��� �Ѵ�.
	public Criteria() {
		// �ʱⰪ�� �ִ´�.
		// ���߿� ���޵Ǵ� ������ �ٲ��. ���޵Ǵ� ���� ������ ���� �ȴ�.
		page = 1;
		perPageNum = 4;
		startRow = 1;
		endRow = 4;
		
		displayPageNum = 3;
		
		prev = false;
		next = false;
	}
	
	// �����Ͱ� ������ ������ ������ ����� �ִ�. 
	// startRow, endRow�� ����Ѵ�.
	public void calcData() {
		// ó�� ���� ������ = (������-1)*�� �������� ������ �������� ����+1
		// (������-1)*���������������ٵ������ǰ��� : ���� ������������ �����͸� �ѱ��.
		startRow = (page-1)*perPageNum+1;
		endRow = startRow + perPageNum - 1;
		
		// �ϴ� �κп� ǥ���� ������ ó���� �ʿ��� ������ ���.
		// totalPage ���Ѵ�. -> startPage, endPage -> prev, next�� ���Ѵ�.
		// prev�� startPage�� 1�� �ƴϸ� true
		// next endPage != totalPage �� true
		// 1. totalPage�� ���Ѵ�.
		// (1-1)/10 -> 0 +1 => 1 , (10-1)/10 -> 1 +1 -> 1
		totalPage = (totalCount-1) / perPageNum + 1;
		System.out.println(getClass().getSimpleName()
				+".calcData().totalPage="+totalPage);
		// 2. startPage, endPage�� ���Ѵ�.
		startPage = (page-1) / displayPageNum * displayPageNum +1;
		endPage = startPage + displayPageNum - 1;
		// endPage�� totalPage�� ���� �� ����.
		// �׷��� ��꿡 ���� endPage�� totalPage���� ũ�� endPage���� totalPage�� �ִ´�.
		if(endPage > totalPage) endPage = totalPage;
		// 3. prev, next�� ���Ѵ�.
		if(startPage != 1) prev = true;
		if(endPage != totalPage) next = true;
	}
}
