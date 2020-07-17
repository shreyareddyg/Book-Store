package com.cg.Dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category1")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
	@Id   
	@Column(length=12)   
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int CategoryId;
	@Column(length=50)
	public String CategoryName;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<Book>();

	public int getCategoryId() {
		return CategoryId;
	}	public void setCategoryId(int categoryId) {


		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public Category(int categoryId, String categoryName, List<Book> books) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
		this.books = books;
	}


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
