package com.cg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.Dto.Category;
import com.cg.Service.CategoryService;
import com.cg.repository.Categoryrepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DeletecategoryApplicationTests {

	@Autowired
	private CategoryService as;
	
	@MockBean
	Categoryrepository crep;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	

	
	 @Test
	 public void removeCategoryTest(){
	 Category c=new Category(101,"horror",null);
	 crep.delete(c);
        verify(crep,times(1)).delete(c);
	 }
	

}
