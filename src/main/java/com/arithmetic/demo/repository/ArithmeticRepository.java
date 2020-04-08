package com.arithmetic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arithmetic.demo.model.ArithmeticEntity;
 
@Repository
public interface ArithmeticRepository
        extends JpaRepository<ArithmeticEntity, Long> {
 
}
