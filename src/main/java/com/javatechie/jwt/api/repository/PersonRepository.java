package com.javatechie.jwt.api.repository;

import com.javatechie.jwt.api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findByUserName(String username);
}
