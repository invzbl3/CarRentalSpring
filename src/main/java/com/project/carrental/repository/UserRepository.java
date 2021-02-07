package com.project.carrental.repository;

import com.project.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select * from users WHERE login=?")
    User findByLogin(@Param("login") String login);
}
