package com.javatechie.jwt.api;

import com.javatechie.jwt.api.entity.Person;
import com.javatechie.jwt.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    private final PersonRepository repository;

    public SpringSecurityJwtExampleApplication(PersonRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initUsers() {
        List<Person> persons = Stream.of(
                new Person(100, "ariel", "taba123", "axrl@gmail.com"),
                new Person(101, "kevin2", "1234k", "kap.sani@yavirac.edu.ec"),
                new Person(102, "michael", "contra1", "user1@gmail.com"),
                new Person(103, "andres", "contra2", "user2@gmail.com"),
                new Person(104, "dany", "contra3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(persons);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
