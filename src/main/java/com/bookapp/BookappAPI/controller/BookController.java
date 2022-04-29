package com.bookapp.bookappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookappapi.dao.BookRepository;
import com.bookapp.bookappapi.model.Book;
import com.bookapp.bookappapi.model.User;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("Books/save")
	public void save(@RequestBody Book book) {
		bookRepository.save(book);
	}



	@GetMapping("Books/list")
	public List<Book> findAll() {
		List<Book> BookList = bookRepository.findAll();
		return BookList;

	}

	@PutMapping("Books/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		Book book = new Book();
		book.setId(id);
		bookRepository.save(book);
	}

	@DeleteMapping("Books/{id}")
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

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
