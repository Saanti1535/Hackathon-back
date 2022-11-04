package com.majorkeytech.hackaton.repository;

import com.majorkeytech.hackaton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByEmailAndPassword(String email, String password);
	Boolean existsByEmail(String email);
}
