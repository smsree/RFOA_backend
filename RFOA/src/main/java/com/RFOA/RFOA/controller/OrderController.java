package com.RFOA.RFOA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RFOA.RFOA.model.OrderMeals;
import com.RFOA.RFOA.repository.OrderRepostiory;

@RestController
@RequestMapping("/orders")
@CrossOrigin("http://localhost:3000")
public class OrderController {
	
	@Autowired
	private OrderRepostiory orderRepository;
	
	@PostMapping("/add")
	public ResponseEntity<String> addOrder(@RequestBody OrderMeals order)
	{
		orderRepository.save(order);
		return new ResponseEntity<String>("order added successfully",HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<OrderMeals> getOrders(){
		return  orderRepository.findAll();
	}
	@GetMapping("/{id}")
	public OrderMeals getOrderById(@PathVariable double id) {
		return orderRepository.findById(id).get();	}

}
