package com.arithmetic.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arithmetic.demo.model.ArithmeticEntity;
import com.arithmetic.demo.repository.ArithmeticRepository;
 
@Service
public class ArithmeticService {
     
    @Autowired
    ArithmeticRepository repository;
     
    public List<ArithmeticEntity> getAllArithmeticExpressions()
    {
        List<ArithmeticEntity> arithmeticExpressionsList = repository.findAll();
         
        if(arithmeticExpressionsList.size() > 0) {
            return arithmeticExpressionsList;
        } else {
            return new ArrayList<ArithmeticEntity>();
        }
    }
}