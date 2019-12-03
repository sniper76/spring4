package com.app.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.vo.CustomUserDetails;

@Repository("userAuthDAO")
public class UserAuthDao {
    
    @Autowired
    private SqlSessionTemplate sqlSession;
 
    public CustomUserDetails getUserById(String username) {
        return sqlSession.selectOne("com.app.dao.UserAuthDao.selectUserById", username);
    }
 
}