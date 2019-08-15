package kosta.forrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kosta.forrest.model.user.dto.UserDTO;
import kosta.forrest.model.user.service.UserService;

@Controller
//@RestController --> ResponseBody�� ���� �־ �̰� ������ �񵿱�ȭ ����� �� ����Ѵ�.
public class UserController {

	@Autowired
	private UserService userService;
	
	//ȸ������������ ��й�ȣ ��ȣȭó���� ���� ��ü�� ���Թ޴´�
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	//ȸ������ ��
	@RequestMapping("registerForm")
	public String registerForm() {
		return "user/registerForm";
	}
	
	
	//ȸ�� �����ϱ� :: redirect ���
	@RequestMapping("registerSuccess") //registerUser
	public String insertUser(UserDTO userDTO) {
		System.out.println("userDTO:" + userDTO);
		userService.registerUser(userDTO);
		return "user/registerSuccess"; //redirect:/
	
	}
	
	//�α��� ��
	@RequestMapping("loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	//ȸ�� �˻� ��
	@RequestMapping("findUserByIdForm")
	public String findIdUser() {
		return "user/findForm";
	}
	
	//Ư�� ȸ�� �˻��ϱ�
	@RequestMapping("user/findUser")
	public ModelAndView findUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		UserDTO userDTO = userService.findUserById(id);
		return new ModelAndView("user/findUser_result","userDTO",userDTO);
	}
	
	//������ �������� ���� ȸ�� ��� �ľ��ϱ�
	@RequestMapping("admin/enterCafe")
	public ModelAndView adminWelcome() {
		return new ModelAndView("admin/main","count",userService.getUserCount());
	}
	
	//���̵� �ߺ�Ȯ��
	@RequestMapping("/idcheckAjax")
	@ResponseBody
	public String idCheckAjax(HttpServletRequest request) {
		return userService.idcheck(request.getParameter("id"));
	}
	
	//�ּ� ������ �˻� :: select form
	@RequestMapping("user/addressList")
	public ModelAndView addressList() {
		System.out.println("addressList");
		return new ModelAndView("user/addressList", "list", userService.getAddressList());
	}
	
	
	@RequestMapping("findUserListByAddress")
	@ResponseBody
	public List<UserDTO> findMemberListByAddress(HttpServletRequest request) { //?address
		List<UserDTO> list=userService.findUserListByAddress(request.getParameter("address"));
		System.out.println("list="+list);
		return list;
	}
	
	@RequestMapping("user/updateForm") 
	public String updateForm() {
		return "user/updateForm";
	}
	
	/* Authentication �� ����ó�� ��� �����صθ� �α׾ƿ� �� �� ������ ��� ����, 
	�׷���  ȸ������ ���� �� ������ ������ Authentication �� �ִ� ������ ����ġ �� �� �� ������ ��ġ�����ֱ� ���ؼ� �ؿ��� ���� set ���� �ٲ���� �ȴ�. 
	
	*/ 
	
	@RequestMapping("updateUserAction")
	public ModelAndView updateUserAction(HttpServletRequest request, UserDTO userDTO) {
		System.out.println("1. UserDTO  :: "+ userDTO);
		//ȸ������ �������� Spring Security ���� ȸ�������� ��ȯ�޴´�
		UserDTO udto = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/* ObjectType���� principal �� �����µ�, ��¥�� ����ִ� ���� MemberVO --- MemberAuthenticationProvider�� 
		return new UsernamePasswordAuthenticationToken(vo, null, authList); �� vo �ε�...*/
		
		System.out.println("2. Spring Security ���� ���� �� ȸ������:" + udto);
		
		//������ ��й�ȣ�� ��ȣȭ�Ѵ� 
		String encodePassword = passwordEncoder.encode(userDTO.getUserPwd());
		userDTO.setUserPwd(encodePassword);
		userService.updateUser(userDTO);
		
		System.out.println("**********************************************");
		// ������ ȸ�������� Spring Security ���� ȸ�������� ������Ʈ�Ѵ� / 
		udto.setUserPwd(encodePassword);
		udto.setUserName(userDTO.getUserName());
		udto.setUserAddr(userDTO.getUserAddr());
		System.out.println("3. Spring Security ���� ���� �� ȸ������:" + udto);
				
		
		return new ModelAndView("user/update_result");
	}
	
}













