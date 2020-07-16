package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.Dto.Book;

@Repository
public interface Bookrepo extends JpaRepository<Book, Integer>{

}
