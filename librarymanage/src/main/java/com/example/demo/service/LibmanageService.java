package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Libmanage;
import com.example.demo.repository.LibmanageRepository;

@Service
public class LibmanageService {
	@Autowired
	LibmanageRepository lr;
	public Libmanage create(Libmanage l)
	{
		return lr.save(l);
		
	}
	public Iterable<Libmanage> readAll()
	{
		return lr.findAll();
		
	}
	public Optional<Libmanage> read(int bno)
	{
		return lr.findById(bno);
	}
	public Libmanage update (Libmanage l)
	{
		return lr.save(l);
	}
	public void delete(int bno)
	{
		 lr.deleteById(bno);
	}
	
	public Iterable<Libmanage>sortlibrary(@PathVariable String field)
 	{
 		return lr.findAll(Sort.by(Direction.DESC, field ));
 	}
 	
 	public Page<Libmanage>paginglibrary(int pageno,int pageSize){
 		Pageable p =PageRequest.of(pageno,pageSize);
 		return lr.findAll(p);
 	}
 	public Page<Libmanage>pagingAndSortinglibrary(int pageNo,int pageSize,String field){
 		Pageable p=PageRequest.of(pageNo, pageSize).withSort(Sort.by(field));
 		return lr.findAll(p);
 		
 	}
 	public Libmanage savelibrary(Libmanage d)
 	{
 		return lr.save(d);
 		
 	}
 	public String deletelibrary(int id)
 	{
 		  lr.deleteById(id);
 		  return"Deleted";
 		
 	}

}
