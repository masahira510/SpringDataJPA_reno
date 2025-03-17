package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ProductService;
import com.example.demo.entity.ProductEntity;
import jakarta.validation.Valid;



@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// ===================Aパターン======================//
	// フォームの入力画面を表示
	@GetMapping("/user/form")
	public String showForm(Model model) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setPrice(0);
		model.addAttribute("productEntity", productEntity);
		return "productForm";
	}
	
	// フォームから送信されたデータを受け取って登録
	@PostMapping("/user/productCreate")
	public String create(@Valid @ModelAttribute ProductEntity productEntity,BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "errorPage";
		}
		String resultMessage = productService.createProduct(productEntity);
		model.addAttribute("message", resultMessage);
		return "result";
	}
	
	
	// ===================Bパターン======================//
	// フォームの入力画面を表示(入力エラーがあれば、エラーページに遷移せずにフォーム入力画面に戻る)
	@GetMapping("/user/formErrorReturn")
	 public String shorFormError(Model model) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setPrice(0);
		model.addAttribute("productEntity", productEntity);
		return "productFormError";
	}
	
	//　フォームから送信されたデータを受け取って登録(入力エラーがあれば、エラーページに遷移せずにフォーム入力画面に戻る)
	@PostMapping("/user/productCreateError")
	public String createError(@Valid @ModelAttribute ProductEntity productEntity,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "productFormError";
		}
		String resultMessage = productService.createProduct(productEntity);
		model.addAttribute("message", resultMessage);
		return "resultB";
	}
	
	// ===================A,Bパターン共通======================//
	//リスト表示
	@GetMapping("/user/getCreate")
	public String get(Model model) {
		List<ProductEntity> products = productService.getProduct();
		model.addAttribute("products", products);
		return "productList";
	}

}
