package com.bookapp.bookappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookappapi.dao.OrderDetailsRepository;
import com.bookapp.bookappapi.model.OrderDetails;
import com.bookapp.bookappapi.model.User;

@RestController
public class OrderController {

	@Autowired
	OrderDetailsRepository orderRepository;

	@PostMapping("Order/save")
	public void save(@RequestBody OrderDetails orderdetails) {

	orderRepository.save(orderdetails);
	}

	@GetMapping("Order/list")
	public List<OrderDetails> findAll() {
		List<OrderDetails> BookList = orderRepository.findAll();
		return BookList;

	}

	@PutMapping("Order/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody OrderDetails orderdetails) {
		
		orderdetails.setId(id);
		orderRepository.save(orderdetails);
	}

	@DeleteMapping("Order/{id}")
	public void delete(@PathVariable("id") Integer id) {
		orderRepository.deleteById(id);
	}

}
