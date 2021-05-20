package com.egzamin.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egzamin.domain.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	Orders findByimie(String imie);
	

}
