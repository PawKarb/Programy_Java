package com.project.rest.api.service;
import java.util.Optional;

import com.project.rest.api.model.Projekt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjektService { 
   Optional<Projekt> getProjekt(Integer projektId);
   Projekt setProjekt(Projekt projekt);
   void deleteProjekt(Integer projektId); 
   Page<Projekt> getProjekty(Pageable pageable);
   Page<Projekt> searchByNazwa(String nazwa, Pageable pageable); 
}