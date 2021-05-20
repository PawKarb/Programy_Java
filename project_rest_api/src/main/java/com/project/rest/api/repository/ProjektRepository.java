package com.project.rest.api.repository;

import java.util.List;

import com.project.rest.api.model.Projekt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjektRepository extends JpaRepository<Projekt, Integer> {
	Page<Projekt> findByNazwaContainingIgnoreCase(String nazwa, Pageable pageable); 
	   List<Projekt> findByNazwaContainingIgnoreCase(String nazwa); 
} 