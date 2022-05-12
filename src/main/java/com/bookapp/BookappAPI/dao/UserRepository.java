package com.bookapp.bookappapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bookappapi.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{

	Optional<User> findByEmailAndPassword(String email, String password);

	

	User findByEmail(String email);

	

}
