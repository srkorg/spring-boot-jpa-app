package com.srk.springbootjpaapp.controller;

import com.srk.springbootjpaapp.model.Users;
import com.srk.springbootjpaapp.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping("/users") // This means URL's start with /users (after Application path)
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @GetMapping(value = "/{name}")
    public Users findByName(@PathVariable final String name) {
        return usersRepository.findByName(name);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users) {
        usersRepository.save(users);
        return usersRepository.findByName(users.getName());
    }
}
