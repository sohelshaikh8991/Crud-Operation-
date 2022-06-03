package com.NimapInfotech.Nimap.CateController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NimapInfotech.Nimap.CategoryEntity.Category;
import com.NimapInfotech.Nimap.CategoryRepo.CategoryRepository;
import com.NimapInfotech.Nimap.Exception.ResourceNotFoundException;
import com.NimapInfotech.Nimap.ProductEntity.Product;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryrepositroy;
	
	@PostMapping("/categories")
	public Category insertCategory(@RequestBody Category category) {
		return categoryrepositroy.save(category);
	}
	
	@GetMapping("/categoriesby")
	public List<Category> getAllCategory() {
		return(List<Category>) categoryrepositroy.findAll();
	}
	
	@GetMapping("/categories/{CategoryId}")
	public Category getCategoryById(@PathVariable(value = "CategoryId") long id) {
	
		return categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found with Id: "+ id));
	}
	
	@PutMapping("/categories/{CategoryId}")
	public Category UpdateCategory(@RequestBody Category category,@PathVariable("CategoryId") long id) {
		Category categoryexist = categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found with Id: "+id));
		categoryexist.setCategoryName(category.getCategoryName());
		categoryexist.setCategoryDescription(category.getCategoryDescription());
		return categoryrepositroy.save(categoryexist);
	}
	
	@DeleteMapping("/categories/{CategoryId}")
	public ResponseEntity<Product> DeleteProduct(@RequestBody Category category,@PathVariable("CategoryId") long id) {
		Category categoryexist = categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
	    categoryrepositroy.delete(categoryexist);
	    return ResponseEntity.ok().build();
	} 
}
