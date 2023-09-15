package com.java.spring.api.user.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.java.spring.api.user.models.User;

public interface UserRepository extends CrudRepository<User, Long>{}