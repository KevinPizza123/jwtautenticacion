package com.javatechie.jwt.api.service;

import com.javatechie.jwt.api.entity.Person;
import com.javatechie.jwt.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(person.getUserName(), person.getPassword(), new ArrayList<>());
    }
}
