package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	List<SubscriptionVO> getAllSubscriptions();

	SubscriptionVO getSubscription(long id);

	SubscriptionVO saveSubscription(SubscriptionVO vo);

}