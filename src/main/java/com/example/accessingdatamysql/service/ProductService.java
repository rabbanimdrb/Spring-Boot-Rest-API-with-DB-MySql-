package com.example.accessingdatamysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.entity.Product;
import com.example.accessingdatamysql.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
//	Save a product
	public Product saveProduct(Product product) {
		return repository.save(product);
		
	}
	
//	Save multiple products
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
//	Get all the products
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
//	Get single products by id
	public Product getProductById( int id ){
		return repository.findById(id).orElse(null);
	}
	
//	Get single products by name
	public Product getProductByName( String name ){
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product with id " + id + " deleted successfully";
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		
		return repository.save(existingProduct);
	}
	
	
}
