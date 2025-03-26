package com.valtech.training.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<UserVO> getAllUsers() {
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping("/")
	public UserVO signIn(@RequestBody UserVO vo) {
		return userService.signIn(vo);
	}
	
	@PostMapping("/subscription/{subscriptionId}")
	public void addUserToSubscription(@PathVariable("id") long subscriptionId,@RequestBody UserVO vo){
		userService.addUserToSubscription(subscriptionId,vo);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUserFromSubscription(@PathVariable("userId") long uid) {
		userService.deleteUserFromSubscription(uid);
	}
	
}
