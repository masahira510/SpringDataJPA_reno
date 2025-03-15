package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.UserService;
import com.example.demo.entity.UserEntity;


@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/user/create")
	public String create(Model model) {
		String message = userService.createUser();
		model.addAttribute("message", message);
		return "user";
	}
	
	@GetMapping("/user/get")
	public String get(Model model) {
		List<UserEntity> user = userService.getUser();
		model.addAttribute("message", user);
		return "user";
	}
	

}
