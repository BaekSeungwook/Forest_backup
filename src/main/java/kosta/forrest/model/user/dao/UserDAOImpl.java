package kosta.forrest.model.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kosta.forrest.model.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Resource	
	private SqlSession sqlSession;
	
	@Override
	public UserDTO findUserById(String id){
		return sqlSession.selectOne("userMapper.findUserById", id);
	}
	@Override
	public List<String> getAddressList(){
		return sqlSession.selectList("userMapper.getAddressList");
	}
	@Override
	public List<UserDTO> findUserListByAddress(String address){
		return sqlSession.selectList("userMapper.findUserListByAddress",address);
	}
	@Override
	public UserDTO login(UserDTO userDTO){
		return sqlSession.selectOne("userMapper.login", userDTO);
	}
	@Override
	public int getUserCount(){
		return sqlSession.selectOne("userMapper.getUserCount");
	}
	@Override
	public void updateUser(UserDTO userDTO) {
		sqlSession.update("userMapper.updateUser", userDTO);			
	}	
	@Override
	public void registerUser(UserDTO userDTO) {
		sqlSession.insert("userMapper.registerUser", userDTO);			
	}
	@Override
	public int idcheck(String id) {
		return sqlSession.selectOne("userMapper.idcheck", id);				
	}
	

}
