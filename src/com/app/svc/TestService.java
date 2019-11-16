package com.app.svc;

import java.util.Map;

public interface TestService {

    public String selectNow() throws Exception;
    
    public Map<String, Object> selectPlayEvolutions() throws Exception;
}