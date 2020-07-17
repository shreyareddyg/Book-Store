package com.cg.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Dto.Book;

import com.cg.Dto.Category;


import com.cg.exceptions.CategoryException;
import com.cg.exceptions.ErrorCode;
import com.cg.exceptions.CategoryProjectException;
import com.cg.repository.Bookrepo;
import com.cg.repository.Categoryrepository;

@Service
@Transactional
public class CategoryService {
	private static final String ACTION_1 = "Exception while writing data to persistant layer";
	
	@Autowired
    private Categoryrepository categoryrepository;
	
	@Autowired
    private Bookrepo bookrepo;
    
  
	public String removeCategory(Integer CategoryId) {
		 if (CategoryId == null) {
	            throw new CategoryException(ErrorCode.BAD_DATA, "Valid CategoryId is required");
	        }
		 
	        try {
			 categoryrepository.removeCategory(CategoryId);	
			 return "deleted";
	        } 
	        
	        catch (Exception e) {
	            throw new CategoryProjectException(ErrorCode.SYSTEM_EXCEPTION,"Can not delete the category as it contains books", e);
	        }	
	
	}


	public Category addCategory(Category category) {
		 if (validateCategory(category)) {
	            try {
		categoryrepository.save(category);
	            } catch (Exception e) {
	                throw new CategoryProjectException(ErrorCode.SYSTEM_EXCEPTION, ACTION_1, e);
	            }
	            return category;
	        }
	        throw new CategoryException(ErrorCode.BAD_DATA, "Valid date is required");
		
	}


	public Book addBook(Book book) {
		if (validateBook(book)) {
            try {
		bookrepo.save(book);
            } catch (Exception e) {
                throw new CategoryProjectException(ErrorCode.SYSTEM_EXCEPTION, ACTION_1, e);
            }
		return book;
		 }
        throw new CategoryException(ErrorCode.BAD_DATA, "Valid date is required");
	}


	public Book btoC(int cid, int bid) {

		Book b=bookrepo.getOne(bid);
		if(b!=null) {
			Category c=categoryrepository.getOne(cid);
			b.setCategory(c);
		}
		return bookrepo.save(b);
	}


	public Category UpdateCategory(Category c) {
		Category ct=categoryrepository.getOne(c.getCategoryId());
		if(ct!=null) {
			ct.setCategoryName(c.getCategoryName());
		}
		return categoryrepository.save(ct);
	}

	
	private Boolean validateCategory(Category category) {
        if (category.getCategoryName() == null || category.getCategoryName().isEmpty()) {
            throw new CategoryException(ErrorCode.BAD_DATA, "Category Name should not be empty");
        }
        return true;
    }

	private Boolean validateBook(Book book) {
        if (book.getAuthor()== null || book.getAuthor().isEmpty()) {
            throw new CategoryException(ErrorCode.BAD_DATA, "Author Name should not be empty");
        }
        if (book.getDescription()== null || book.getDescription().isEmpty()) {
            throw new CategoryException(ErrorCode.BAD_DATA, "Description should not be empty");
        }
        if (book.getTitle() == null ||  book.getTitle().isEmpty()) {
            throw new CategoryException(ErrorCode.BAD_DATA, "Title should not be empty");
        }
        if(book.getPrice() == 0)
        {
        	throw new CategoryException(ErrorCode.BAD_DATA, "Price has to be more than zero");
        }
        return true;
    }

}


