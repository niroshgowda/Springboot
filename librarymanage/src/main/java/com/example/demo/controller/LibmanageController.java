package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Libmanage;
import com.example.demo.service.LibmanageService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class LibmanageController {
         
	@Autowired
	LibmanageService lm;
	
	@Operation(summary="Creates a new library")
	@ApiResponses(value= {@ApiResponse(responseCode="201",description="library created successfully"),
			@ApiResponse(responseCode="400",description="library is invalid bno")})
	@ResponseStatus(HttpStatus.CREATED)
	
	@PostMapping(produces ="application/json",consumes="application/json")
	public ResponseEntity<Libmanage> create(final @RequestBody Libmanage l){
		Libmanage createdlibrary=lm.create(l);
		return ResponseEntity.ok(createdlibrary);
	}
	@Operation(summary="get a library wiht an bno")
	@ApiResponses(value= {@ApiResponse(responseCode="201",description="getting library successfully"),
			@ApiResponse(responseCode="400",description="invalid bno credentials"),@ApiResponse(responseCode="404",description="library not found")})
	@GetMapping(value="/{bno}",produces="application/json")
	public ResponseEntity<Optional<Libmanage>>read(final @PathVariable Integer bno)
	{
		Optional<Libmanage> createdlibrary= lm.read(bno);
		return ResponseEntity.ok(createdlibrary);
	}
	@Operation(summary="updates a library with a bno")
	@ApiResponses(value= {@ApiResponse(responseCode="200",description="library updated successfully"),
			@ApiResponse(responseCode="400",description="library is invalid bno"),
			@ApiResponse(responseCode="401",description="invalbno credentials"),
			@ApiResponse(responseCode="404",description="library not found")})
	@PutMapping(value="/{bno}",produces="application/json",consumes="application/json")
	public ResponseEntity<Libmanage>updateById(final @RequestBody Libmanage l)throws JsonProcessingException
	{
		
			final Libmanage updatelibrary=lm.update(l);
			return ResponseEntity.ok(updatelibrary);
		
	}
	@Operation(summary="deletes the library by given bno")
	@ApiResponses(value= {@ApiResponse(responseCode="200",description="library deleted successfully"),
			@ApiResponse(responseCode="401",description="invalid credentials"),
			@ApiResponse(responseCode="404",description="library is not found")})
	@DeleteMapping("/{bno}")
	public void delete(final @PathVariable Integer bno)
	{
		lm.delete(bno);
	}
	
	@Operation(summary="get a library book details")
	@ApiResponses(value= {@ApiResponse(responseCode="201",description="getting library successfully"),
			@ApiResponse(responseCode="400",description="invalid bno credentials"),@ApiResponse(responseCode="404",description="library not found")})
	@GetMapping(produces="application/json")
	public Iterable<Libmanage> readAll()
	{
		return lm.readAll();
	}
	
	
	@GetMapping("/get/{field}")
	Iterable<Libmanage>librarySort(@PathVariable("field") String field)
	{
		return lm.sortlibrary(field);
	}
	@GetMapping(value="/paginglibrary/{pageNo}/{pageSize}")
	Page<Libmanage>libraryPaging(@PathVariable("pageNo")int pageno,
			@PathVariable("pageSize")int pageSize){
		return lm.paginglibrary(pageno, pageSize);
	}
	@GetMapping(value="/pagingSortinglibrary/{pageNo}/{pageSize}/{field}")
	Page<Libmanage>libraryPagingAndSorting(@PathVariable("pageNo")int pageno,
			@PathVariable("pageSize")int pageSize,
			@PathVariable("field") String field){
				return lm.pagingAndSortinglibrary(pageno,pageSize,field);
		
	} 
	
	@PostMapping("/post")
	public Libmanage savelibrary(@RequestBody Libmanage l)
	{
        return lm.savelibrary(l);
	}
	@PutMapping("/put/{bno}")
	public Libmanage update(@RequestBody Libmanage l)
	{
		return lm.savelibrary(l);
	}
	@DeleteMapping("/delete/{bno}")
	public String deletelibrary(@PathVariable("bno")int bno)
	{
		return lm.deletelibrary(bno);
		
	}
}
