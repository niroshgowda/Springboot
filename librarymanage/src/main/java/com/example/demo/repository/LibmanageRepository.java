package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Libmanage;

@Repository
public interface LibmanageRepository extends CrudRepository<Libmanage,Integer> ,PagingAndSortingRepository<Libmanage, Integer>{

}
