package com.bookapp.bookappapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.bookappapi.model.OrderDetails;




@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer>{

}
