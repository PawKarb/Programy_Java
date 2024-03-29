package com.project.rest.api.controller;

import java.net.URI;
import javax.validation.Valid;

import com.project.rest.api.model.Projekt;
import com.project.rest.api.service.ProjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("http://localhost:3000/")
@RestController        
@RequestMapping("/api")
public class ProjektController {
	
	 private ProjektService projektService;
	
	 @Autowired    
	 public ProjektController(ProjektService projektService) 
	 {  
		 this.projektService = projektService;
	 	} 
	 
	 @GetMapping("/projekty/{projektId}")
	 ResponseEntity<Projekt> getProjekt(@PathVariable Integer projektId)
	 {
		 return ResponseEntity.of(projektService.getProjekt(projektId));
	 }
	 
	  @PostMapping(path = "/projekty")
	  ResponseEntity<Void> createProjekt(@Valid @RequestBody Projekt projekt) 
	  {                                                                            
		  Projekt createdProjekt = projektService.setProjekt(projekt);                
	  
	      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{projektId}").buildAndExpand(createdProjekt.getProjektId()).toUri(); 
	      return ResponseEntity.created(location).build(); 
	
	  }
	  
	  @PutMapping("/projekty/{projektId}")   
	  public ResponseEntity<Void> updateProjekt(@Valid @RequestBody Projekt projekt,@PathVariable Integer projektId)
	  {   
		  return projektService.getProjekt(projektId).map(p -> 
		  {                   projektService.setProjekt(projekt);         
		  return new ResponseEntity<Void>(HttpStatus.OK);        
		  })    
			.orElseGet(() -> ResponseEntity.notFound().build()); 
	  }
	  
	  @DeleteMapping("/projekty/{projektId}")
	  public ResponseEntity<Void> deleteProjekt(@PathVariable Integer projektId)
	  {      
		  return projektService.getProjekt(projektId).map(p ->
		  {          projektService.deleteProjekt(projektId);
		  return new ResponseEntity<Void>(HttpStatus.OK); 
		  }).orElseGet(() -> ResponseEntity.notFound().build()); 
		  }

	  @GetMapping(value = "/projekty")
	  Page<Projekt> getProjekty(Pageable pageable) {
	  return projektService.getProjekty(pageable);
	  }

	  @GetMapping(value = "/projekty", params="nazwa")
	  Page<Projekt> getProjektyByNazwa(@RequestParam String nazwa, Pageable pageable) {
	  return projektService.searchByNazwa(nazwa, pageable);
	  }
}