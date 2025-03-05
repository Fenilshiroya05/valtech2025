package com.valtech.training.restapis.controllers;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {
	
	//@RequestMapping(method = RequestMethod.GET,path = "/hello") 1st way
	@GetMapping("/hello/{name}") // 2nd way
	public String hello(@PathVariable("name") String name, @RequestParam("times") int times) {
		String res="";
		for (int i = 0; i < times; i++) {
			res+=name+" ";
		}
		return "Hello "+res+" >>>>";
	}
}
