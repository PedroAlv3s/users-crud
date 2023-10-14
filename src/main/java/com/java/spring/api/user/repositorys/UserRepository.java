package com.java.spring.api.user.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.api.user.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findAll();
    public Optional<User> findById(Long id);
    public void delete(User user);
    public void deleteById(Long id);
    public <UserTemp extends User> UserTemp save(UserTemp user);
}