package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ProductServiceJS;
import com.example.demo.entity.ProductEntityJS;


@Controller
public class ProductControllerJS {
	@Autowired
	private ProductServiceJS productServiceJS;
	
	// ===================Cパターン======================//
	// フォーム画面を表示
	@GetMapping("/user/formJS")
	public String showFormJS(Model model) {
		model.addAttribute("productEntityJS", new ProductEntityJS());
		return "productFormJS";
	}
	
	//フォームから送信されたデータを登録(JSでフォーム入力値をチェックする)
	@PostMapping("/user/productCreateJS")
	public String createJS(@ModelAttribute ProductEntityJS productEntityJS,Model model) {
		String message = productServiceJS.createProductJS(productEntityJS);
		model.addAttribute("message", message);
		return "resultC";	
	}
	
	// リスト表示 Cパターンで使用
	@GetMapping("/user/getCreateJS")
	public String getJS(Model model) {
		List<ProductEntityJS> productsJS = productServiceJS.getProductJS();
		model.addAttribute("productsJS", productsJS);
		return "productListJS";
	}

}
