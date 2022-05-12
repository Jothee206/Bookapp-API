package com.bookapp.bookappapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

 @Data
@ToString
@Entity
@Table(name="book")
	public class Book {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement.
	
	@Column (name="id")
	private Integer id;
	
	@Column(name="book_id")
	private Integer bookId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="title")
	private String title;
	
	@Column(name="authorname")
	private String authorname;
	
	@Column(name="published_year")
	private Integer publishedYear;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ratings")
	private Integer ratings;
	
	@Column(name="image_url")
	private String imageUrl;
	
	
	
}
