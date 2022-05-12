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

import com.bookapp.bookappapi.Service.BookService;
import com.bookapp.bookappapi.dao.BookRepository;
import com.bookapp.bookappapi.dto.MessageDTO;
import com.bookapp.bookappapi.model.Book;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookService bookservice;

	@PostMapping("Books/save")
	public ResponseEntity<?> save(@RequestBody Book book) {
		try {
			bookservice.save(book);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	
	}

	@PutMapping("Books/{id}")
	// public void update(@PathVariable("id") Integer id, @RequestBody Book book) {
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Book book) {
		try {
			bookservice.update(id, book);
			MessageDTO message = new MessageDTO("Success");
       return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message
					, HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("Book/{id}")
	public void delete(@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);
	}
	
	@GetMapping("Books/{id}")
	public Book get(@PathVariable("id") Integer id) {
		return bookRepository.findById(id).get();
	}

	@GetMapping("Books/list")
	public List<Book> displaylist() {
		List<Book> findAll = null;
		try {
			findAll = bookservice.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return findAll;

	}

}