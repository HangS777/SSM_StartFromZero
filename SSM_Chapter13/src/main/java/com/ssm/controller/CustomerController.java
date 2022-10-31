package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.po.Customer;

@Controller
public class CustomerController {

	/**
	 * Receive the JSON data from web request, and return JSON format object
	 */
	@RequestMapping(value="/testJson")
	@ResponseBody
	public Customer testJson(@RequestBody Customer customer) {
		System.out.println(customer);
		return customer;
	}
	
	/**
	 * Receive RESTFul style request
	 */
	@GetMapping(value="/customer/{id}")
	@ResponseBody
	public Customer selectCustomer(@PathVariable("id") Integer id) {
		System.out.println(id);
		Customer customer = new Customer();
		
		if (id == 10) {
			customer.setLoginname("wujie");
		}
		return customer;
	}
}
