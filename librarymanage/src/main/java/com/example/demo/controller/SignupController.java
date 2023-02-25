package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SignupEntity;
import com.example.demo.service.SignupService;

@RestController
@RequestMapping("/api")
public class SignupController {
	@Autowired
	  SignupService signUp ;
	  
	  @PostMapping("/signUp")
	  public String singUp(@RequestBody SignupEntity signup)
	  {
		   return signUp.saveSignup(signup);
		  
	  }

}
