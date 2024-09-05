package com.blog.services;

import java.util.List;
import com.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	public CategoryDto getcategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getCategories();

}
