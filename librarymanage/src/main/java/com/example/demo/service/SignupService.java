package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SignupEntity;
import com.example.demo.repository.SignUpRepository;

@Service
public class SignupService {
	@Autowired
	SignUpRepository signupRepository;
	public String saveSignup(SignupEntity signup)
	{
		signupRepository.save(signup);
		return "Thanks for SignUp";
	}

}
