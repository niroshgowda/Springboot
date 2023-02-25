package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.SignupEntity;

@Repository
public interface SignUpRepository extends CrudRepository<SignupEntity,String>{
	@Query("select s.userName,s.password from SignupEntity s where s.userName=?1")
	Iterable<SignupEntity> readByuserName(String userName);

}
