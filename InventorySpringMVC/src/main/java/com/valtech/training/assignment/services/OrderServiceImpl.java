package com.valtech.training.assignment.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Orders;
import com.valtech.training.assignment.entities.Orders.OrderStatus;
import com.valtech.training.assignment.repo.ItemRepo;
import com.valtech.training.assignment.repo.OrderRepo;
import com.valtech.training.assignment.vos.AddItemVO;
import com.valtech.training.assignment.vos.CustomerVO;
import com.valtech.training.assignment.vos.ItemVO;
import com.valtech.training.assignment.vos.LineItemVO;
import com.valtech.training.assignment.vos.OrderViewVO;
import com.valtech.training.assignment.vos.OrderVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private InventoryService inventoryServices;

	@Autowired
	private CustomerService customerServices;

	@Override
	public OrderVO placeOrder(OrderVO orderVO) {
		Orders order = orderVO.to();
		boolean isOutOfStock = false;

		for (LineItemVO lineItemVO : orderVO.getLineItems()) {
			Item item = inventoryServices.getItemById(lineItemVO.itemId()).to();

			if (item.checkItemAvailability(lineItemVO.itemQuantity())) {
				item.setCurrentQuantity(item.getCurrentQuantity() - lineItemVO.itemQuantity());
				inventoryServices.createOrUpdateInventory(ItemVO.from(item));

				if (item.checkReOrderStatus(lineItemVO.itemQuantity())) {
					inventoryServices.refillInventory(lineItemVO.itemId());
				}
			} else {
				isOutOfStock = true;
				break;
			}
		}

		if (!isOutOfStock) {
			List<LineItem> lineItems = orderVO.getLineItems().stream()
					.map(lineItemVO -> new LineItem(inventoryServices.getItemById(lineItemVO.itemId()).to(), order,
							lineItemVO.itemQuantity()))
					.collect(Collectors.toList());

			order.setLineItems(lineItems);
			order.setCustomer(customerServices.getCustomerById(orderVO.getCustomerId()).to());
			order.setOrderStatus(OrderStatus.PROCESSING);

			return OrderVO.from(orderRepo.save(order));
		}

		return null;
	}

	@Override
	public List<OrderVO> getOrdersByCustomerId(long id) {
		List<OrderVO> orderVO = orderRepo.getOrdersByCustomerId(id).stream().map(w -> OrderVO.from(w))
				.collect(Collectors.toList());
		return orderVO;

	}

	@Override
	public List<OrderVO> getAllOrders() {
		List<OrderVO> orderVO = orderRepo.findAll().stream().map(w -> OrderVO.from(w)).collect(Collectors.toList());
		return orderVO;
	}

	@Override
	public List<OrderViewVO> getOrderById(long id) {
		Orders order = orderRepo.getReferenceById(id);
		List<OrderViewVO> orderDisplay = order.getLineItems().stream()
				.map(w -> new OrderViewVO(w.getItem().getId(), w.getItem().getName(), w.getOrderQuantity()))
				.collect(Collectors.toList());
		return orderDisplay;

	}

	@Override
	public OrderStatus getOrderStatus(long id) {

		return orderRepo.getReferenceById(id).getOrderStatus();

	}

	@Override
	public void updateOrderStatus(long id, OrderStatus orderStatus) {

		Orders order = orderRepo.getReferenceById(id);
		order.setOrderStatus(orderStatus);
		orderRepo.save(order);
	}

}
