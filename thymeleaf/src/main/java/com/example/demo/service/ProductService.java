package com.example.demo.service;


import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ProductRepository;
import com.example.demo.entity.ProductEntity;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public String createProduct(ProductEntity productEntity) {
		productRepository.save(productEntity);
		return "登録完了";
	}
	
	public List<ProductEntity> getProduct() {
		return productRepository.findAll();
	}
	
}
