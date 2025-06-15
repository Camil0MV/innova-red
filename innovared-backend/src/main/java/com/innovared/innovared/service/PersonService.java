package com.innovared.innovared.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.innovared.innovared.dto.SignupRequest;
import com.innovared.innovared.exception.ResourceNotFoundException;
import com.innovared.innovared.model.Person;
import com.innovared.innovared.repository.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final PersonRepository repository;

    public PersonService(PersonRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person register(SignupRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        if (repository.existsById(request.getId())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        Person person = new Person();
        person.setId(request.getId());
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setCountry(request.getCountry());
        person.setDepartmentProvince(request.getDepartmentProvince());
        person.setCity(request.getCity());
        person.setEmail(request.getEmail());
        person.setPassword(passwordEncoder.encode(request.getPassword()));
        return repository.save(person);
    }

    public Person getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada"));
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person update(String id, Person updatedPerson, SignupRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        if (repository.existsById(request.getId())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        Person existing = getById(id);
        existing.setFirstName(updatedPerson.getFirstName());
        existing.setLastName(updatedPerson.getLastName());
        existing.setEmail(updatedPerson.getEmail());
        existing.setCountry(updatedPerson.getCountry());
        existing.setDepartmentProvince(updatedPerson.getDepartmentProvince());
        existing.setCity(updatedPerson.getCity());
        return repository.save(existing);
    }

    public void delete(String id) {
        Person existing = getById(id);
        repository.delete(existing);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
