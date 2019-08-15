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
//@RestController --> ResponseBody랑 같이 있어서 이걸 쓰려면 비동기화 통신일 때 사용한다.
public class UserController {

	@Autowired
	private UserService userService;
	
	//회원정보수정시 비밀번호 암호화처리를 위한 객체를 주입받는다
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	//회원가입 폼
	@RequestMapping("registerForm")
	public String registerForm() {
		return "user/registerForm";
	}
	
	
	//회원 가입하기 :: redirect 방식
	@RequestMapping("registerSuccess") //registerUser
	public String insertUser(UserDTO userDTO) {
		System.out.println("userDTO:" + userDTO);
		userService.registerUser(userDTO);
		return "user/registerSuccess"; //redirect:/
	
	}
	
	//로그인 폼
	@RequestMapping("loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	//회원 검색 폼
	@RequestMapping("findUserByIdForm")
	public String findIdUser() {
		return "user/findForm";
	}
	
	//특정 회원 검색하기
	@RequestMapping("user/findUser")
	public ModelAndView findUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		UserDTO userDTO = userService.findUserById(id);
		return new ModelAndView("user/findUser_result","userDTO",userDTO);
	}
	
	//관리자 권한으로 들어가서 회원 명수 파악하기
	@RequestMapping("admin/enterCafe")
	public ModelAndView adminWelcome() {
		return new ModelAndView("admin/main","count",userService.getUserCount());
	}
	
	//아이디 중복확인
	@RequestMapping("/idcheckAjax")
	@ResponseBody
	public String idCheckAjax(HttpServletRequest request) {
		return userService.idcheck(request.getParameter("id"));
	}
	
	//주소 종류별 검색 :: select form
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
	
	/* Authentication 은 세션처럼 어디에 저장해두면 로그아웃 할 때 까지는 계속 존재, 
	그래서  회원정보 수정 시 수정된 정보와 Authentication 에 있는 정보가 불일치 할 때 그 정보를 일치시켜주기 위해서 밑에서 값을 set 으로 바꿔줘야 된다. 
	
	*/ 
	
	@RequestMapping("updateUserAction")
	public ModelAndView updateUserAction(HttpServletRequest request, UserDTO userDTO) {
		System.out.println("1. UserDTO  :: "+ userDTO);
		//회원정보 수정위해 Spring Security 세션 회원정보를 반환받는다
		UserDTO udto = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/* ObjectType으로 principal 이 들어오는데, 진짜로 들어있는 것은 MemberVO --- MemberAuthenticationProvider의 
		return new UsernamePasswordAuthenticationToken(vo, null, authList); 의 vo 인데...*/
		
		System.out.println("2. Spring Security 세션 수정 전 회원정보:" + udto);
		
		//변경할 비밀번호를 암호화한다 
		String encodePassword = passwordEncoder.encode(userDTO.getUserPwd());
		userDTO.setUserPwd(encodePassword);
		userService.updateUser(userDTO);
		
		System.out.println("**********************************************");
		// 수정한 회원정보로 Spring Security 세션 회원정보를 업데이트한다 / 
		udto.setUserPwd(encodePassword);
		udto.setUserName(userDTO.getUserName());
		udto.setUserAddr(userDTO.getUserAddr());
		System.out.println("3. Spring Security 세션 수정 후 회원정보:" + udto);
				
		
		return new ModelAndView("user/update_result");
	}
	
}













