package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

  boolean existsByLastnameAndFirstname(String lastname, String firstaname);

  boolean existsByEmail(String pseudo);

  User findByEmail(String pseudo);
}

