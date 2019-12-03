package com.app.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.dao.UserAuthDao;
import com.app.vo.CustomUserDetails;

public class CustomUserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserAuthDao userAuthDAO;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails user = userAuthDAO.getUserById(username);
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
 
}