package com.project.rest.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.project.rest.api.model.Student;
import com.project.rest.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class StudentController {
	 private StudentService studentService;
		
	 @Autowired    
	 public StudentController(StudentService studentService) 
	 {  
		 this.studentService = studentService;
	 	} 
	 
	 @GetMapping("/studenci/{studentId}")
	 ResponseEntity<Student> getStudent(@PathVariable Integer studentId)
	 {
		 return ResponseEntity.of(studentService.getStudent(studentId));
	 }
	 
	  @PostMapping(path = "/studenci")
	  ResponseEntity<Void> createStudent(@Valid @RequestBody Student student) 
	  {                                                                            
		  Student newStudent = studentService.setStudent(student);
	  
	      URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(newStudent).toUri();
	      return ResponseEntity.created(location).build(); 
	
	  }
	  
	  @PutMapping("/studenci/{studentId}")   
	  public  ResponseEntity<Void> updateStudent(@Valid @RequestBody Student student,@PathVariable Integer studentId)
	  {   
		  return studentService.getStudent(studentId).map(p -> 
		  {                   studentService.setStudent(student);         
		  return new ResponseEntity<Void>(HttpStatus.OK);        
		  })    
			.orElseGet(() -> ResponseEntity.notFound().build()); 
	  }
	  
	  @DeleteMapping("/studenci/{studentId}")
	  public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId)
	  {      
		  return studentService.getStudent(studentId).map(p ->
		  {          studentService.deleteStudent(studentId); 
		  	return new ResponseEntity<Void>(HttpStatus.OK);
		  }).orElseGet(() -> ResponseEntity.notFound().build()); 
		  } 
}