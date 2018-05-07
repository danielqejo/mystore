package com.example.mystore.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mystore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {
	
	Product findById(BigInteger id);
	
	@Query("SELECT p FROM Product p WHERE p.name like %:name%")
	List<Product> findByNameContaining(String name);
	
}
