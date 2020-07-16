package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.Dto.Category;


@Repository
public interface Categoryrepository extends JpaRepository<Category, Integer>{

//	@Modifying
//	@Query(value = "DELETE FROM Category  Where CategoryId = :CategoryId And not exists( Select 1 From Book  Where category = :CategoryId)")
//	void removeCategory(@Param("CategoryId") int CategoryId);
	
	@Modifying
	@Query(value = "DELETE FROM Category  Where CategoryId = :CategoryId")
	void removeCategory(@Param("CategoryId") int CategoryId);
	
	
}

