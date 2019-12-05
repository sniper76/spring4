package com.app.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("comMDao")
public class ComMDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@PostConstruct
	public void init() {
		System.out.println("\n\n\n");
		System.out.println("ComMDao init !!");
		System.out.println("\n\n\n");
	}
	
	public List<Map<String, Object>> selectCodes() {
		return sqlSession.selectList("com.app.dao.ComMDao.selectCodes");
	}
}
