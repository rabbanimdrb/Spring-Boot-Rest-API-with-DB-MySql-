package com.example.accessingdatamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.entity.Product;
import com.example.accessingdatamysql.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/productbyid/{id}")
	public Product findProductById(@PathVariable int id){
		return service.getProductById(id);
	}
	
	@GetMapping("/productbyname/{name}")
	public Product findProductByName(@PathVariable String name){
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProducts(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProductsById(@PathVariable int id){
		service.deleteProduct(id);
	}

}
