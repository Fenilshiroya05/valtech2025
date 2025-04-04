package com.valtech.training.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.valtech.training.assignment.services.CustomerService;
import com.valtech.training.assignment.services.OrderService;
import com.valtech.training.assignment.vos.CustomerVO;
import com.valtech.training.assignment.vos.OrderVO;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerServices;

    @Autowired 
    private OrderService orderServices;

    @GetMapping("/")
    public String registerCustomer(Model model) {
        model.addAttribute("customers", customerServices.getCustomers());
        return "Customer";
    }

    @ModelAttribute("customers")
    public CustomerVO createCustomer(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age, @RequestParam(required = false) String currentCity, @RequestParam(required = false) Integer currentPinCode,
                                     @RequestParam(required = false) String currentStreet, @RequestParam(required = false) String permanantCity,@RequestParam(required = false) Integer permanantPinCode, @RequestParam(required = false) String permanantStreet) {
        if (name != null && age != 0 && currentCity != null && currentPinCode != 0 && currentStreet != null && permanantCity != null 
            && permanantPinCode != 0 && permanantStreet != null) {
            return new CustomerVO(0, name, age, currentCity, currentPinCode, currentStreet, permanantCity, permanantPinCode, permanantStreet, null);
        } else {
            return new CustomerVO(0, null, 0, null, 0, null, null, 0, null, null);
        }
    }

    @PostMapping("/")
    public String createCustomer(@ModelAttribute("customers") CustomerVO customerVO, Model model) {
        CustomerVO customer = customerServices.createCustomer(customerVO);
        model.addAttribute("customer", customer);
        return "Order";
    }

    @GetMapping("/{id}")
    public String getOrderByCustomer(@PathVariable long id, Model model) {
        CustomerVO customer = customerServices.getCustomerById(id);
        List<OrderVO> orderVOS = orderServices.getOrdersByCustomerId(id);
        model.addAttribute("customer", customer);
        model.addAttribute("orders", orderVOS);
        return "Customer";
    }
}
