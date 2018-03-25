package com.srk.springbootjpaapp.repo;

import com.srk.springbootjpaapp.model.UsersContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface UsersContactRepository extends JpaRepository<UsersContact, UUID> {

}
