package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SignupEntity;
import com.example.demo.repository.SignUpRepository;

@Service
public class LoginService {
	@Autowired
	SignUpRepository signUpRepository;
	public Iterable<SignupEntity> readByuserName(String userName)
	{
		return signUpRepository.readByuserName(userName);
	}

}
