package com.project.carrental.repository;

import com.project.carrental.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
    public <S extends Passport> S save(S s);
    public void delete(Integer integer);
    public List<Passport> findAll();
    public Passport findOne(Integer integer);
}
