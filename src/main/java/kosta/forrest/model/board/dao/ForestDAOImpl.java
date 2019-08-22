package kosta.forrest.model.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.forrest.model.board.dto.Criteria;
import kosta.forrest.model.board.dto.ForestDTO;

@Repository
public class ForestDAOImpl implements ForestDAO {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<ForestDTO> selectAll(Criteria cri) {
		List<ForestDTO> list = session.selectList("forestMapper.selectAll", cri);
		return list;
	}

	@Override
	public ForestDTO selectByForestNo(int forestNo) {
		ForestDTO forestDTO= session.selectOne("forestMapper.selectByForestNo", forestNo);
		return forestDTO;
	}

	@Override
	public List<ForestDTO> selectBySearch(String keyWord, String keyField) {
		Map<String, String> map = new HashMap<String, String>();
		
		if(keyField!=null) map.put("keyField", keyField);
		if(keyWord!=null) map.put("keyWord",keyWord);
		List<ForestDTO> list = session.selectList("forestMapper.selectBySearch", map);
		return list;
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
	
	// 게시판 전체 글의 갯수 구하는 메서드
	public Integer getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName()+".getTotalCount()");
		return session.selectOne
		("forestMapper.totalCount", cri);
	}
}
