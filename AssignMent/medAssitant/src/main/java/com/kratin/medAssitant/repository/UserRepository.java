package com.kratin.medAssitant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.medAssitant.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email, String password);
}
