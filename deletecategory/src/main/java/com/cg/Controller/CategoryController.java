package com.cg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Dto.Book;
import com.cg.Dto.Category;
import com.cg.Service.CategoryService;



@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	

	@PostMapping("/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category ) {
			Category cat=catService.addCategory(category);
			ResponseEntity<Category> responseEntity = new ResponseEntity<Category>(cat,HttpStatus.OK);
			return responseEntity;
		}

	
	@PostMapping("/createbook")
	public Book addBook(@RequestBody Book book ) {
			Book b=catService.addBook(book);
			//ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(b,HttpStatus.OK);
			return b;
		}
	
	@PutMapping("/assignBookToCat/{CategoryId}/{book_id}")
	public Book assignbooktoC(@PathVariable(value="CategoryId")int CategoryId,
			@PathVariable(value="book_id")int book_id) {
		return catService.btoC(CategoryId, book_id);
		
	}
	
	@PutMapping("/UpdateCategory")
	public Category updateC(@RequestBody Category category) {
		return catService.UpdateCategory(category);
		
	}
	
	@DeleteMapping(path="/{CategoryId}")
	public ResponseEntity<String> removeCategory(@PathVariable int CategoryId) {
		
		ResponseEntity<String> rs =  new ResponseEntity<String>(catService.removeCategory(CategoryId),HttpStatus.OK);
		
		return rs;
	} 
}
