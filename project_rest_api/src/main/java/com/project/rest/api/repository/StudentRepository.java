package com.project.rest.api.repository;

import java.util.Optional;

import com.project.rest.api.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
   Optional<Student> findByNrIndeksu(String nrIndeksu); 
   Page<Student> findByNrIndeksuStartsWith(String nrIndeksu, Pageable pageable); 
   Page<Student> findByNazwiskoStartsWithIgnoreCase(String nazwisko, Pageable pageable); 
}
