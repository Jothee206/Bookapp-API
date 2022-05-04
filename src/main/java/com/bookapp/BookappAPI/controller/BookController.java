package com.bookapp.bookappapi.controller;

import java.util.List;
import java.util.Optional;

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

import com.bookapp.bookappapi.Service.BookService;
import com.bookapp.bookappapi.dao.BookRepository;
import com.bookapp.bookappapi.model.Book;



@RestController
public class BookController {
	
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookservice;
	 
	@PostMapping("Books/save")
	public  ResponseEntity <String> save(@RequestBody Book book) {
		try {
			
		    bookservice.save(book);
		return new ResponseEntity<String> ("success",HttpStatus.OK);
		
	}catch(Exception e) {
		return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	}


	@GetMapping("Books/list")
	public List<Book> displaylist() {
		List<Book> findAll=null;
		try {
			findAll=bookservice.findAll();
		}catch(Exception e) {
			e.getMessage();
		}
		return findAll;
		
	}


	@PutMapping("Books/{id}")
	//public void update(@PathVariable("id") Integer id, @RequestBody Book book) { 
   public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody Book book){
		try {
			bookservice.save(book);
			return new ResponseEntity<String> ("success",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String> (e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
   
   
		
	}

	/*@DeleteMapping("Books/{id}")
	public void delete(@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);
	}

	
	@GetMapping("Books/findBook/{id}")
	public Book findById(@PathVariable("id") Integer id) {
		Optional<Book> book =bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return null;
		}

	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
