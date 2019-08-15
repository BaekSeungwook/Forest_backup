package kosta.forrest.model.user.service;

import java.util.List;

import kosta.forrest.model.user.dto.AuthorityDTO;
import kosta.forrest.model.user.dto.UserDTO;

public interface UserService {
	
	UserDTO findUserById(String id);

	List<String> getAddressList();

	List<UserDTO> findUserListByAddress(String address);

	UserDTO login(UserDTO memberVO);

	int getUserCount();

	void updateUser(UserDTO vo);

	void registerUser(UserDTO vo);

	String idcheck(String id);
	
	List<AuthorityDTO> selectAuthorityByUsername(String username);
}
