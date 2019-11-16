package com.app.svc.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.TestDao;
import com.app.svc.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestDao testDao;	
	
	@Override
    public String selectNow() throws Exception {
		return testDao.selectNow("com.app.dao.TestDao.selectNow");
    }
	
	@Override
	public Map<String, Object> selectPlayEvolutions() throws Exception {
		return testDao.selectPlayEvolutions("com.app.dao.TestDao.selectPlayEvolutions");
	}
}

