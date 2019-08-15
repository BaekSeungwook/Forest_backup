package kosta.forrest.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.forrest.model.user.dao.AuthoritiesDAO;
import kosta.forrest.model.user.dao.UserDAO;
import kosta.forrest.model.user.dto.AuthorityDTO;
import kosta.forrest.model.user.dto.UserDTO;
import kosta.forrest.util.Constants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	/*
	 * 비밀번호 암호화를 위한 객체를 주입받는다 
	 */
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public UserDTO findUserById(String id) {		
		return userDAO.findUserById(id);
	}

	@Override
	public List<String> getAddressList() {		
		return userDAO.getAddressList();
	}

	@Override
	public List<UserDTO> findUserListByAddress(String address) {		
		return userDAO.findUserListByAddress(address);
	}

	@Override
	public UserDTO login(UserDTO userDTO) {
		return userDAO.login(userDTO);
	}

	@Override
	public int getUserCount() {
		return userDAO.getUserCount();
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		userDAO.updateUser(userDTO);
	}
    @Transactional
	@Override
	public void registerUser(UserDTO userDTO) {
    	//비밀번호 암호화
    	//System.out.println("vo.getPassword() : " + vo.getPassword());
        String encodedPassword = passwordEncoder.encode(userDTO.getUserPwd());
        //System.out.println("encodedPassword : " + encodedPassword);
        userDTO.setUserPwd(encodedPassword);
        userDAO.registerUser(userDTO);		
		
		//권한등록
		/*AuthorityVO authority=new AuthorityVO(vo.getId(),"ROLE_MEMBER");
		memberDAO.registerRole(authority);*/
		authoritiesDAO.insertAuthority(new AuthorityDTO(userDTO.getUserId(), Constants.ROLE_MEMBER));
		if(userDTO.getUserType().equals("1")) {
			authoritiesDAO.insertAuthority(new AuthorityDTO(userDTO.getUserId(), Constants.ROLE_ADMIN));
		}			
	}

	@Override
	public String idcheck(String id) {
		int count = userDAO.idcheck(id);
		return (count==0) ? "ok":"fail"; 	
	}

	@Override
	public List<AuthorityDTO> selectAuthorityByUsername(String username) {
		
		return authoritiesDAO.selectAuthorityByUserName(username);
	}


}
