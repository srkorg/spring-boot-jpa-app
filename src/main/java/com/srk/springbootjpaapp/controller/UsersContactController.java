package com.srk.springbootjpaapp.controller;

import com.srk.springbootjpaapp.model.Users;
import com.srk.springbootjpaapp.model.UsersContact;
import com.srk.springbootjpaapp.model.UsersLog;
import com.srk.springbootjpaapp.repo.UsersContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usersContact")
public class UsersContactController {
	@Autowired
	private UsersContactRepository usersContactRepository;

	@GetMapping(value="/all")
	public List<UsersContact> findAll() {
		return usersContactRepository.findAll();
	}

	@GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {

        UsersLog usersLog = new UsersLog();
        usersLog.setLog("Mobile Log");

        UsersLog usersLog2 = new UsersLog();
        usersLog2.setLog("Email Log");

        Users users = new Users();
	    users.setName(name)
                .setSalary(3000L)
                .setTeamName("Dev")
                .setUsersLogs(Arrays.asList(usersLog, usersLog2));

        UsersContact usersContact = new UsersContact();
	    usersContact.setPhoneNo(95502160)
                .setEmail("vijay@gmail.com")
                .setUsers(users);

        usersContactRepository.save(usersContact);

	    return usersContactRepository.findAll();
    }
}
