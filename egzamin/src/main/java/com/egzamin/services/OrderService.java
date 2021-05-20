package com.egzamin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egzamin.repositories.OrdersRepository;
import com.egzamin.domain.Kucharz;
import com.egzamin.domain.Orders;

@Service
public class OrderService {
	@Autowired
	private OrdersRepository orderRepo;
		
	public Orders findOrders(String imie){
		return orderRepo.findByimie(imie);
	}
	public void SaveAllOrders(Iterable entities) {
		orderRepo.saveAll(entities);
	}
	public List<Orders> FindAllOrders() {
		return orderRepo.findAll();
	}
}

