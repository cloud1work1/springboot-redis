package com.javacodegeeks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
