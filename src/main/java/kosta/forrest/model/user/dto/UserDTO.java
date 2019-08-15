package kosta.forrest.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
	private String userId; // 회원 ID
	private String userPwd; // 비밀번호
	private String userName; //이름
	private String userEmail; //이메일 주소
	private String userEnroll; //가입일
	private String userTel; //연락처
	private String userAddr; //주소
	private String userGrade; //등급(관리자로 등급 올려줄 때 사용)
	private int qnaNo; //1:1게시판 - 글 번호(qna_no)
	
	private String userType;

	
}
