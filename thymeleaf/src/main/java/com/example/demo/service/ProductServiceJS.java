package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ProductRepositoryJS;
import com.example.demo.entity.ProductEntityJS;

@Service
public class ProductServiceJS {

	@Autowired
	private ProductRepositoryJS productRepositoryJS;
	
	// フォーム入力値をJSでチェックするためのもの
	public String createProductJS(ProductEntityJS productEntityJS) {
		productRepositoryJS.save(productEntityJS);
		return "登録完了";
	}
	
	public List<ProductEntityJS> getProductJS() {
		return productRepositoryJS.findAll();
	}
	
}
