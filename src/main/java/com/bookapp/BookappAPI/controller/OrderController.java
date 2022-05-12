package com.bookapp.bookappapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookappapi.Service.OrderService;
import com.bookapp.bookappapi.dao.OrderDetailsRepository;
import com.bookapp.bookappapi.dto.MessageDTO;
import com.bookapp.bookappapi.model.OrderDetails;

@RestController
public class OrderController {

	@Autowired
	OrderDetailsRepository orderRepository;
	
	@Autowired
	OrderService orderService;


	@PostMapping("Order/save")
	public ResponseEntity  <String> save(@RequestBody OrderDetails orderdetails){
		try {
		orderService.save(orderdetails);
			MessageDTO message=new MessageDTO("success");
			
			return new ResponseEntity<String> (HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("Order/list")
	
		public List<OrderDetails> displaylist() {
			List<OrderDetails> findAll=null;
			try {
				findAll=OrderService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
			return findAll;

		}


	@PutMapping("Order/{id}")
	 public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody OrderDetails orderdetails){
		try {
			orderService.update(id,orderdetails);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);
		}

		}

	@DeleteMapping("Order/{id}")
	public void delete(@PathVariable("userid") Integer userid) {
		orderRepository.deleteById(userid);
	}
		                            
		
	}


