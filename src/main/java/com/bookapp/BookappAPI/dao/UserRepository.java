package com.bookapp.bookappapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bookappapi.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{

}
