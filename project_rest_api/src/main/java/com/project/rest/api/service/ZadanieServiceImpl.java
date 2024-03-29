package com.project.rest.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.project.rest.api.model.Zadanie;
import com.project.rest.api.repository.ZadanieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ZadanieServiceImpl implements ZadanieService {

	 private ZadanieRepository zadanieRepository;
	 
	 @Autowired
	 public ZadanieServiceImpl(ZadanieRepository projektRepository)
	   {     
		   this.zadanieRepository = zadanieRepository;  
		   } 
	
	@Override
	public Optional<Zadanie> getZadanie(Integer Id) {
		return zadanieRepository.findById(Id);
	}

	@Override
	public Zadanie setZadanie(Zadanie zadanie) {
		Zadanie zd = zadanie;
		zadanieRepository.save(zd);
		return zd;
	}

	@Override
	 @Transactional
	public void deleteZadanie(Integer Id) {
		zadanieRepository.deleteById(Id);
		
	}

	@Override
	public Page<Zadanie> getZadania(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Zadanie> searchByNazwa(Integer id, Pageable pageable) {
		 Page<Zadanie> pr = zadanieRepository.findZadaniaProjektu(id, pageable);
		   return pr;
	}
}