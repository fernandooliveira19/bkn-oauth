package com.fernando.oliveira.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fernando.oliveira.oauth.entity.User;

@Component
@FeignClient(name="bkn-user",  path="/users")
public interface UserFeignClient {

	@GetMapping(value="/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
