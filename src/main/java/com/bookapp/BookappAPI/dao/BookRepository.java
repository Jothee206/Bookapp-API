package com.bookapp.bookappapi.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bookappapi.model.Book;
@Repository

public interface BookRepository extends JpaRepository<Book,Integer>{

	

	Optional<Book> findByTitle(String string);

	 

	




}
