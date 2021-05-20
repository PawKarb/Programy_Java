package com.egzamin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egzamin.repositories.PizzaRepository;
import com.egzamin.domain.Orders;
import com.egzamin.domain.Pizza;

@Service
public class PizzaService {
	@Autowired
	private PizzaRepository pizzaRepo;
	
	public List<Pizza> findAllPizzas(){
		return pizzaRepo.findAll();
	}

}
