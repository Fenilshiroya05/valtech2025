package com.valtech.training.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valtech.training.assignment.services.InventoryService;
import com.valtech.training.assignment.vos.ItemVO;

@Controller
@RequestMapping("/api/v1/items")
public class InventoryController {

	
	@Autowired
	private InventoryService inventoryServicesImpl;
	
	
	@GetMapping("/")
	public String items(Model model){
		
		model.addAttribute("itemLists",inventoryServicesImpl.getAllItems());
		System.out.println(inventoryServicesImpl.getAllItems());
		if(model.getAttribute("id")==null) {
			model.addAttribute(model);
		}
		return "Item";
	}
	
	
	@PostMapping("/create")
	public String addItems(@ModelAttribute ItemVO itemVO,Model model) {
		
		inventoryServicesImpl.createOrUpdateInventory(itemVO);
		
		return "redirect:/api/v1/items/";
		
	}
	
}
