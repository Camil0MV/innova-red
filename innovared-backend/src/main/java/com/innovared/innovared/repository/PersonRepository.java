package com.innovared.innovared.repository;

import com.innovared.innovared.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsById(String id);
}
