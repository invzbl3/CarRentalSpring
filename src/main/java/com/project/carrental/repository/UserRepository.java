package com.project.carrental.repository;

import com.project.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public <S extends User> S save(S s);
    public void delete(Integer integer);
    public List<User> findAll();
    User findByLogin(@Param("login") String login);
    public User findOne(Integer integer);
}
