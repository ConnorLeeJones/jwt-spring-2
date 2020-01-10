package com.connor.demo.repository;

import com.connor.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findUserById(Long id);
    User findUserByUsername(String username);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}