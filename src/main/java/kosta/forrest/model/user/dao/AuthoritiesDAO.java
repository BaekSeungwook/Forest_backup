package kosta.forrest.model.user.dao;

import java.util.List;

import kosta.forrest.model.user.dto.AuthorityDTO;

public interface AuthoritiesDAO {
	
	int insertAuthority(AuthorityDTO authority);
	List<AuthorityDTO> selectAuthorityByUserName(String username);

}
