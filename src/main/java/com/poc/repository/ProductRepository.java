package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
