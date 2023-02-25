package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SignupEntity;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	 
	@Autowired
	LoginService loginservice;
	@GetMapping("/getInfo/{userName}")
	public Iterable<SignupEntity>readByuserName(@PathVariable String userName)
	{
		return loginservice.readByuserName(userName);
	}

}
