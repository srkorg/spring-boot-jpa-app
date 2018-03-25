package com.srk.springbootjpaapp.repo;

import com.srk.springbootjpaapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

    Users findByName(String name);
}
