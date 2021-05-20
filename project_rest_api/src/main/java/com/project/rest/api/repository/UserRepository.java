package com.project.rest.api.repository;


import com.project.rest.api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByLogin(String login);
}
