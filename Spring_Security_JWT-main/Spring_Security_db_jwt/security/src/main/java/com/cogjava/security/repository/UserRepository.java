package com.cogjava.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogjava.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findBySname(String username);
}
