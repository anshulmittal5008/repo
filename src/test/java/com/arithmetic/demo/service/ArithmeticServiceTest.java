package com.arithmetic.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.arithmetic.demo.model.ArithmeticEntity;
import com.arithmetic.demo.repository.ArithmeticRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArithmeticServiceTest {

	@InjectMocks
	private ArithmeticRepository arithmeticRepository;

	@Mock
	private ArithmeticService arithmeticService;

	public void testGetAllArithmeticExpressions() {
		ArithmeticEntity arithmeticEntity = new ArithmeticEntity();
		arithmeticEntity.setExpression("(2+4)*2");
		arithmeticEntity.setResult("12");
		when(arithmeticRepository.findAll()).thenReturn(arithmeticEntity);
		List<ArithmeticEntity> arithmeticEntities = arithmeticService.getAllArithmeticExpressions();
		assertNotNull(arithmeticEntities);

	}
}
