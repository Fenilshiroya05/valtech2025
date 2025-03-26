package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<SubscriptionVO> getAllSubscriptions() {
		return subscriptionRepo.findAll().stream().map(s -> SubscriptionVO.from(s)).collect(Collectors.toList());
	}
	
	@Override
	public SubscriptionVO saveSubscription(SubscriptionVO vo) {
		List<User> u = userRepo.findAllById(vo.userIds());
		Subscription sc= vo.to(u);
		sc= subscriptionRepo.save(sc);
		return SubscriptionVO.from(sc);
	}
	
	@Override
	public SubscriptionVO getSubscription(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}

	
}
