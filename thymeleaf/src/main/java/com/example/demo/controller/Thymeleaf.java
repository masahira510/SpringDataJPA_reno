package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Thymeleaf {
	@GetMapping("/")
	public String index(Model model) {
		User user = new User();
		user.setName("田中　太郎");
		user.setEmail("tanaka.taro@example.com");
		user.setPhone("000-000-0000");
		
		model.addAttribute("top","https://www.google.com/");
		model.addAttribute("about","https://www.yahoo.co.jp/");
		model.addAttribute("contact","https://www.youtube.com/");
		model.addAttribute("user", user);
		model.addAttribute("radioButtons", java.util.Arrays.asList("⚪︎⚪︎⚪︎の問い合わせ︎︎︎","×××の問い合わせ","▲▲▲の問い合わせ"));
		return "thymeleaf";
	}
}
