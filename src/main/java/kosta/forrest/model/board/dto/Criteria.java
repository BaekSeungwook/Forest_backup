package kosta.forrest.model.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *  - 현재 페이지의 데이터를 가져 오기 위한 정보
 *  페이지, 한페이지의 표시할 데이터의 갯수, 시작 줄 번호, 끝 줄 번호
 *  
 *  - 화면에 보여줄 페이지 번호
 *  총 데이터의 갯수, 총 페이지의 갯수
 *  한페이지에 표시한 페이지 번호의 갯수, 시작페이지, 끝페이지
 *  이전 페이지 유무, 다음 페이지의 유무
 */

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Criteria {

	// DB에서 페이지 처리된 데이터를 가져 오는데 필요한 정보.
	private int page, perPageNum, startRow, endRow;
	
	// JSP에서 하단 부분의 페이지 표시 부분에 필요한 정보
	private int totalCount, totalPage, displayPageNum, startPage, endPage;
	
	private boolean prev, next;
	
	// 검색을 위한 멤버변수 추가
	private String searchType; // 검색 항목 이름
	private String keyword; // 검색하는 문자열

	// 맨처음 시작할때 list.do로 시작하므로 페이지는 1, 한 페이지에 표시할 데이터의 갯수 10으로 정한다.
	// 기본 생성자(파라메터가 없는 생성자)를 이용해서 정해 줘야 한다.
	public Criteria() {
		// 초기값을 넣는다.
		// 나중에 전달되는 값으로 바뀐다. 전달되는 값이 없으면 유지 된다.
		page = 1;
		perPageNum = 4;
		startRow = 1;
		endRow = 4;
		
		displayPageNum = 3;
		
		prev = false;
		next = false;
	}
	
	// 데이터가 들어오면 페이지 정보를 계산해 넣다. 
	// startRow, endRow를 계산한다.
	public void calcData() {
		// 처음 시작 데이터 = (페이지-1)*한 페이지에 보여줄 데이터의 갯수+1
		// (페이지-1)*한페이지에보여줄데이터의갯수 : 이전 페이지까지의 데이터를 넘긴다.
		startRow = (page-1)*perPageNum+1;
		endRow = startRow + perPageNum - 1;
		
		// 하단 부분에 표시한 페이지 처리에 필요한 데이터 계산.
		// totalPage 구한다. -> startPage, endPage -> prev, next를 구한다.
		// prev는 startPage가 1이 아니면 true
		// next endPage != totalPage 면 true
		// 1. totalPage를 구한다.
		// (1-1)/10 -> 0 +1 => 1 , (10-1)/10 -> 1 +1 -> 1
		totalPage = (totalCount-1) / perPageNum + 1;
		System.out.println(getClass().getSimpleName()
				+".calcData().totalPage="+totalPage);
		// 2. startPage, endPage를 구한다.
		startPage = (page-1) / displayPageNum * displayPageNum +1;
		endPage = startPage + displayPageNum - 1;
		// endPage는 totalPage를 넘을 수 없다.
		// 그런데 계산에 의해 endPage가 totalPage보다 크면 endPage에다 totalPage을 넣는다.
		if(endPage > totalPage) endPage = totalPage;
		// 3. prev, next를 구한다.
		if(startPage != 1) prev = true;
		if(endPage != totalPage) next = true;
	}
}
