package com.cg.Dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.tuple.GenerationTiming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
public class Book {
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	//@ManyToOne
	//@JsonIgnore
	//@JoinColumn(name="CategoryId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity=Category.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "CategoryId")
	public Category category;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	private int book_id;
	@Column(length=128)
	private String title;
	@Column(length=64)
	private String author;
	@Column(length=200)
	private String description;
	@Column(length=10)
	private int ISBN;
	@Column(length=10)
	private float price;
	private Date published_Date;
	@Lob
	@Column
	@Basic(fetch = FetchType.LAZY)
	private byte[] icon;
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPublished_Date() {
		return published_Date;
	}
	public void setPublished_Date(Date published_Date) {
		this.published_Date = published_Date;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
}
