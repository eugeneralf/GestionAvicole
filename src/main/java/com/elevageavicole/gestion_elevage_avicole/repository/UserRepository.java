package com.elevageavicole.gestion_elevage_avicole.repository;

import com.elevageavicole.gestion_elevage_avicole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}