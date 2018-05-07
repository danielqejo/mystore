package com.example.mystore.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mystore.entity.Product;
import com.example.mystore.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductRepository productRepository;
	
	public ProductController(@Autowired ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping(path="/list")
	public List<Product> getList() {
		return productRepository.findAll();
	}
	
	@GetMapping(path="/by-id/{id}")
	public Product getById(@PathVariable("id") BigInteger id) {
		return productRepository.findById(id);
	}
	
	
	@GetMapping(path="/by-name/{name}")
	public List<Product> getByName(@PathVariable("name") String name) {
		return productRepository.findByNameContaining(name);
	}

}
