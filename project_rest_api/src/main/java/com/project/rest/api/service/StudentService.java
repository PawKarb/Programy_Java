package com.project.rest.api.service;

import java.util.Optional;

import com.project.rest.api.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService { 
   Optional<Student> getStudent(Integer Id);
   Student setStudent(Student student);
   void deleteStudent(Integer Id);
   Page<Student> getStudenci(Pageable pageable);
   Page<Student> searchByNazwisko(String nazwa, Pageable pageable); 
} 
