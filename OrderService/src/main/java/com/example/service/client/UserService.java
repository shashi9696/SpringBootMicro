package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.client.UserResponse;

@FeignClient(name="USER-SERVICE/api/users")
public interface UserService {
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getSingleUser(@PathVariable("id") Long userId);

}
