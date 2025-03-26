package com.valtech.training.registerservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id,int age ,String name, String mobile,String email, Boolean kid,long subscriptionId) {

	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getAge(),u.getName(), u.getMobile(), u.getEmail(), u.isKid(),u.getSubscription().getId());
	}
	public User to(Subscription s) {
		User user = new User(id,name,age,mobile,email,kid);
		user.setSubscription(s);
		return user;
	}
	
	public static List<UserVO> from(List<User> u){
		return u.stream().map(user-> UserVO.from(user)).collect(Collectors.toList());
	}
}
