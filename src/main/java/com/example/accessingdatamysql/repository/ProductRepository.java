package com.example.accessingdatamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	
}
