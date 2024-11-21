package com.wipro.velocity.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.velocity.ims.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
}
