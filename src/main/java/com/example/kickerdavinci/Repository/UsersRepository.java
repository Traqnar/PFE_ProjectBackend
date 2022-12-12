package com.example.kickerdavinci.Repository;

import com.example.kickerdavinci.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

  boolean existsByEmail(String email);

  User findByEmail(String email);
  User findById(long id);
  void deleteById(long id);

  Iterable<User> findAllByAdminFlag(boolean flag);
}

