package com.bookapp.bookappapi.Validation;

import org.springframework.stereotype.Component;

import com.bookapp.bookappapi.model.Book;

@Component
public class BookValidation {
	
	public static void validatebook(Book book) throws Exception{
		
		if(book.getBookId()==null) {
			throw new Exception ("invalid bookId");
		}
		
	
	if(book.getCategory()==null||book.getCategory().trim()=="") {
		throw new Exception("invalid category");
	}

	if(book.getTitle()==null||book.getTitle().trim()=="") {
		throw new Exception("invalid title");
	}
	if(book.getAuthorname()==null||book.getAuthorname().trim()=="") {
		
	
	}
	
	
	}
	}

	

	
	

	
