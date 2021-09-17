package com.poc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.domain.Product;
import com.poc.repository.ProductRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProductdataApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	@Order(1)
	public void testCreate() {
		Product p = new Product();
		p.setId(1L);
		p.setName("iPhone XR");
		p.setDesc("Fantastic");
		p.setPrice(1000.00);
		productRepository.save(p);
		assertNotNull(productRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Product> list = productRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead() {
		Product product = productRepository.findById(1L).get();
		assertEquals("iPhone XR", product.getName());
	}
	
	@Test
	@Order(4)
	public void testUpdate () {
		Product p = productRepository.findById(1L).get();
		p.setPrice(800.00);
		productRepository.save(p);
		assertNotEquals(700.00, productRepository.findById(1L).get().getPrice());
	}
	
	@Test
	@Order(5)
	public void testDelete () {
		productRepository.deleteById(1L);
		assertThat(productRepository.existsById(1L)).isFalse();
	}

}
