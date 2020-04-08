package com.arithmetic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
@Configuration
@ComponentScan(basePackages = {"com.arithmetic.demo"})
@EnableAutoConfiguration
*/
public class ArithmeticExpressionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArithmeticExpressionApplication.class, args);
	}

}
