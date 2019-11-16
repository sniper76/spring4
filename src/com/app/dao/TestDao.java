package com.app.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String selectNow(String queryId) {
		return sqlSession.selectOne(queryId);
	}
	
	public Map<String, Object> selectPlayEvolutions(String queryId) {
		return sqlSession.selectOne(queryId);
	}
}
