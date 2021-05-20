package com.project.rest.api.service;

import java.util.Optional;

import com.project.rest.api.model.Zadanie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZadanieService { 
   Optional<Zadanie> getZadanie(Integer Id);
   Zadanie setZadanie(Zadanie zadanie);
   void deleteZadanie(Integer Id);
   Page<Zadanie> getZadania(Pageable pageable);
   Page<Zadanie> searchByNazwa(Integer id, Pageable pageable); 
} 