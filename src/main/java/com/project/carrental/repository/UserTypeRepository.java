package com.project.carrental.repository;

import com.project.carrental.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    public <S extends UserType> S save(S s);
    public void delete(Integer integer);
    public List<UserType> findAll();
}
