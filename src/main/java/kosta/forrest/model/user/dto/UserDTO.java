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
	private String userId; // ȸ�� ID
	private String userPwd; // ��й�ȣ
	private String userName; //�̸�
	private String userEmail; //�̸��� �ּ�
	private String userEnroll; //������
	private String userTel; //����ó
	private String userAddr; //�ּ�
	private String userGrade; //���(�����ڷ� ��� �÷��� �� ���)
	private int qnaNo; //1:1�Խ��� - �� ��ȣ(qna_no)
	
	private String userType;

	
}
