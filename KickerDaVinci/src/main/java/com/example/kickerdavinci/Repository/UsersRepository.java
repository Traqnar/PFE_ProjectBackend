package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

  boolean existsByEmail(String email);

  User findByEmail(String email);
}

