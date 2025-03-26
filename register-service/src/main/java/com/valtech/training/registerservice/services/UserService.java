package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO signIn(UserVO vo);

//	List<UserVO> getUsersBySubscriptionId(long subId);

	UserVO getUserById(long id);

	UserVO addUserToSubscription(long id, UserVO vo);

//	UserVO registerUser(UserVO vo);

	List<UserVO> getAllUser();

	void deleteUserFromSubscription(long id);

}