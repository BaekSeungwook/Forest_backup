package kosta.forrest.model.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.forrest.model.board.dto.ForestDTO;

@Repository
public class ForestDAOImpl implements ForestDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<ForestDTO> selectAll() {
		List<ForestDTO> list = session.selectList("forestMapper.selectAll");
		return list;
	}

	@Override
	public ForestDTO selectByForestNo(int forestNo) {
		ForestDTO forestDTO= session.selectOne("forestMapper.selectByForestNo", forestNo);
		return forestDTO;
	}

	@Override
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ForestDTO forestDTO) {
		int result = session.insert("forestMapper.forestInsert", forestDTO);
		return result;
	}
	
	@Override
	public int update(ForestDTO forestDTO) {
		System.out.println(forestDTO);
		int result = session.update("forestMapper.forestUpdate", forestDTO);
		return result;
	}

	@Override
	public int delete(int forestNo) {
		int result = session.delete("forestMapper.forestDelete", forestNo);
		return result;
	}



}
