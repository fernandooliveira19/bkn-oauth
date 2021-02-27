package com.fernando.oliveira.oauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fernando.oliveira.oauth.client.UserFeignClient;
import com.fernando.oliveira.oauth.entity.User;

@Service
public class UserService implements UserDetailsService{

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient client;
	
	public User findByEmail(String email) {
		User user = client.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + email);
		
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = client.findByEmail(email).getBody();
		if(user == null) {
			logger.error("Email not found: " + email);
			throw new UsernameNotFoundException("Email not found");
		}
		
		logger.info("Email found: " + email);
		
		return user;
	}

}
