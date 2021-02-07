package com.project.carrental.repository;

import com.project.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
