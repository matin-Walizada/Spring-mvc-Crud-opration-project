package com.spring.mvc.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.mvc.products.entity.UserInfo;

@Service
public class UserSerivceDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate  jdbcTemplate;
	
	
	public boolean checkUserNameAndPassword(String username, String password) {
		
List<UserInfo> theUserInfos = jdbcTemplate.query("select username,password from userinfo where username=? and password=?",
				
				new Object[] {username,password},
				new BeanPropertyRowMapper(UserInfo.class));
		
		return theUserInfos.size() > 0;
		
	}
	

}
