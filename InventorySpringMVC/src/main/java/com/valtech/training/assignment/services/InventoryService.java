package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.vos.ItemVO;

public interface InventoryService {


	ItemVO getItemById(long id);

	ItemVO refillInventory(long id);

	ItemVO createOrUpdateInventory(ItemVO item);

	List<ItemVO> getAllItems();

}