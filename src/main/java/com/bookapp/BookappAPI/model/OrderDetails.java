package com.bookapp.bookappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_details")
	public class OrderDetails{


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
		
		private int id;
		
		@Column(name="book_id")
        private int bookId;
		
		private String title;
		
		
		
			
		
		
		
		
	}

