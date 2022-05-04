package com.bookapp.bookappapi.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookapp.bookappapi.Validation.BookValidation;
import com.bookapp.bookappapi.dao.BookRepository;
import com.bookapp.bookappapi.model.Book; 

@Service
public class BookService {

@Autowired
BookRepository bookRepository;

public  void save(Book book) throws Exception{
	try {
		BookValidation.validatebook(book);
		bookRepository.save(book);
	} catch (Exception e) {
		throw new Exception(e.getMessage());
	}
	
}
public List<Book> findAll() throws Exception{
	List<Book> listBook=null;
	try {
		listBook=bookRepository.findAll();
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}
	return listBook;
	
}
public void update(@PathVariable("id") Integer id, @RequestBody Book book) throws Exception { 
	try {
		book.setId(id);
		bookRepository.save(book);
		BookValidation.validatebook(book);
	}catch (Exception e) {
		throw new Exception(e.getMessage());
	}
}


}