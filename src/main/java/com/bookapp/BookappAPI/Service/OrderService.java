package com.bookapp.bookappapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.bookappapi.Validation.UserValidation;
import com.bookapp.bookappapi.dao.OrderDetailsRepository;
import com.bookapp.bookappapi.model.OrderDetails;

@Service
public class OrderService {

@Autowired
static
OrderDetailsRepository orderdetailsRepository;

public void save(OrderDetails orderdetails) throws Exception {
	try {
	
	orderdetailsRepository.save(orderdetails);
	}
	catch(Exception e) {
		throw new Exception(e.getMessage());
	}
}
public static  List<OrderDetails> findAll() throws Exception{
	List<OrderDetails> listOrder=null;
	try {
		listOrder=orderdetailsRepository.findAll();
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
	return listOrder;
	
}
public void update(Integer id,OrderDetails orderdetails) throws Exception {
	try {
		orderdetails.setId(id);
		
		orderdetailsRepository.save(orderdetails);
	}catch(Exception e) {
		
		throw new Exception(e.getMessage());
	}
}
public OrderDetails findById(Integer id) {
	Optional<OrderDetails> order=orderdetailsRepository.findById(id);
	if(order.isPresent()) {
		return order.get();
	}else {
	return null;
	}
}
public void deleteById(Integer id) throws Exception {
	try {
	orderdetailsRepository.deleteById(id);
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
}

}
