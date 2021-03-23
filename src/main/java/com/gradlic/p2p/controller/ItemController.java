package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.Category;
import com.gradlic.p2p.model.Item;
import com.gradlic.p2p.repository.CategoryRepository;
import com.gradlic.p2p.repository.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("api/v1/items/{categoryid}")
	public void saveItem(@PathVariable int categoryid, @RequestBody Item item) {
		Optional<Category> optional = categoryRepository.findById(categoryid);
		if (!optional.isPresent()) {
			throw new RuntimeException("No category found with given id: "+categoryid);
		}
		
		item.setCategory(optional.get());
		
		itemRepository.save(item);
		
	}
	
	@PutMapping("api/v1/items/{id}")
	public void updateItem(@RequestBody Item item, @PathVariable int id) {
		Optional<Item> optional = itemRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new RuntimeException("No item found with given id: "+id);
		}
		
		item.setId(optional.get().getId());
		
		itemRepository.save(item);
	}
	
	@GetMapping("api/v1/items")
	public List<Item> getItem() {
		return itemRepository.findAll();
	}
	
	@GetMapping("api/v1/items/{id}")
	public Item getItemById(@PathVariable int id) {
		Optional<Item> optional = itemRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new RuntimeException("No item found with given id: "+id);
		}
		
		return optional.get();
	}
	
	

}
