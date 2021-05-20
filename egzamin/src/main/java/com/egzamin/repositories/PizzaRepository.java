package com.egzamin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egzamin.domain.Orders;
import com.egzamin.domain.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	Pizza findBynazwap(String nazwa);
	void saveAndFlush(Orders o);
}
