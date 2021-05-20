package com.project.rest.api.controller;

import java.net.URI;

import javax.validation.Valid;

import com.project.rest.api.model.Zadanie;
import com.project.rest.api.service.ZadanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class ZadanieController {
	 private ZadanieService zadanieService;
		
	 @Autowired    
	 public ZadanieController(ZadanieService zadanieService) 
	 {  
		 this.zadanieService = zadanieService;
	 	} 
	 
	 @GetMapping("/zadania/{zadanieId}")
	 ResponseEntity<Zadanie> getZadanie(@PathVariable Integer studentId)
	 {
		 return ResponseEntity.of(zadanieService.getZadanie(studentId));
	 }
	 
	  @PostMapping(path = "/zadania")
	  ResponseEntity<Void> createZadanie(@Valid @RequestBody Zadanie zadanie) 
	  {                                                                            
		  Zadanie newZadanie = zadanieService.setZadanie(zadanie);
	  
	      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{zadanieId}").buildAndExpand(newZadanie).toUri();
	      return ResponseEntity.created(location).build(); 
	
	  }
	  
	  @PutMapping("/zadania/{zadanieId}")   
	  public  ResponseEntity<Void> updateZadanie(@Valid @RequestBody Zadanie zadanie,@PathVariable Integer zadanieId)
	  {   
		  return zadanieService.getZadanie(zadanieId).map(p -> 
		  {                   zadanieService.setZadanie(zadanie);         
		  return new ResponseEntity<Void>(HttpStatus.OK);        
		  })    
			.orElseGet(() -> ResponseEntity.notFound().build()); 
	  }
	  
	  @DeleteMapping("/zadania/{zadanieId}")
	  public ResponseEntity<Void> deleteZadanie(@PathVariable Integer zadanieId)
	  {      
		  return zadanieService.getZadanie(zadanieId).map(p -> 
		  {          zadanieService.deleteZadanie(zadanieId); 
		  return new ResponseEntity<Void>(HttpStatus.OK); 
		  }).orElseGet(() -> ResponseEntity.notFound().build()); 
		  }	  
}