package com.NimapInfotech.Nimap.ProController;

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
import com.NimapInfotech.Nimap.ProductDto.ProductDto;
import com.NimapInfotech.Nimap.ProductEntity.Product;
import com.NimapInfotech.Nimap.ProductRepo.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productrepositroy;
	CategoryRepository categoryRepository;
	
	@PostMapping("/products")
	public Product insertProduct(@RequestBody ProductDto productDto) {
		System.out.println(productDto.getCategoryId());
		Category category = categoryRepository.findById(productDto.getCategoryId()).get();
		Product product = null;
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		product.setCategory(category);
		return productrepositroy.save(product);
	}
	
	@GetMapping("/productsby")
	public List<Product> getAllProduct() {
		return(List<Product>) productrepositroy.findAll();
	}
	
	@GetMapping("/products/{ProductId}")
	public Product getProductById(@PathVariable(value = "ProductId") long id) {
	
		return productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+ id));
	}
	
	@PutMapping("/products/{ProductId}")
	public Product UpdateProduct(@RequestBody Product product,@PathVariable("ProductId") long id) {
		Product productexist = productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
		productexist.setProductName(product.getProductName());
		productexist.setProductPrice(product.getProductPrice());
		return productrepositroy.save(productexist);
	}
	
	@DeleteMapping("/products/{ProductId}")
	public ResponseEntity<Product> DeleteProduct(@RequestBody Product product,@PathVariable("ProductId") long id) {
		Product productexist = productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
	    productrepositroy.delete(productexist);
	    return ResponseEntity.ok().build();
	}
	
	/*
	 * @GetMapping("/teacherByProduct/{productid}") public List<Product>
	 * productByCategory(@PathVariable("productId") long id) { List<Product>
	 * productlist = new java.util.ArrayList()<>(); productlist =
	 * teacher_services.getTeacherByProduct(productid); return teacherlist; }
	 */

}
