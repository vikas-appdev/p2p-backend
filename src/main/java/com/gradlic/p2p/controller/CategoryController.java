package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.Category;
import com.gradlic.p2p.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("api/v1/categories")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	@GetMapping("api/v1/categories/{id}")
	public Category getAllCategory(@PathVariable int id){
		Optional<Category> optional = categoryRepository.findById(id);
		if(!optional.isPresent()) {
			throw new RuntimeException("No category found with given id: "+id);
		}
		
		return optional.get();
	}
	
	@PostMapping("api/v1/categories")
	public void saveCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	
	@PutMapping("api/v1/categories/{id}")
	public void updateCategory(@RequestBody Category category, @PathVariable int id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("No category found with given id: "+id);
		}
		
		category.setId(optional.get().getId());
		
		categoryRepository.save(category);
	}
	
	@DeleteMapping("api/v1/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryRepository.deleteById(id);
	}

}
