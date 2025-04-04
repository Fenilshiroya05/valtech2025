package com.valtech.training.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.valtech.training.assignment.entities.Orders.OrderStatus;
import com.valtech.training.assignment.services.OrderService;
import com.valtech.training.assignment.vos.LineItemVO;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
public class OrdersController {
    
    @Autowired
    private OrderService orderServices;

    @GetMapping("/")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderServices.getAllOrders());
        return "Order";
    }

    @PostMapping("/place")
    public String createOrder(@ModelAttribute LineItemVO itemVO, Model model, @RequestParam(required = false) Integer customerId) {
        if (itemVO != null) {
            List<LineItemVO> itemList = (List<LineItemVO>) model.getAttribute("itemsl");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
            itemList.add(itemVO);
            model.addAttribute("itemsl", itemList);
        }

        if (customerId != null) {
            model.addAttribute("customerId", customerId);
        }

        return "Order";
    }

    @GetMapping("/{id}")
    public String getOrderById(Model model, @PathVariable long id) {
        model.addAttribute("order", orderServices.getOrderById(id));
        model.addAttribute("OrderStatus", orderServices.getOrderStatus(id));
        return "OrderDetails";
    }

    @PostMapping("/{id}")
    public String updateOrder(@PathVariable long id, @RequestParam String orderStatus) {
        orderServices.updateOrderStatus(id, OrderStatus.valueOf(orderStatus));
        return "redirect:/api/v1/orders/";
    }
}
