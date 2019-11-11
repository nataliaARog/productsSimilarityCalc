package com.productsSimilarityCalc.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.productsSimilarityCalc.controller","com.productsSimilarityCalc.service","com.productsSimilarityCalc.serviceimpl"})
public class Init {

	public static void main(String[] args) {
		SpringApplication.run(Init.class, args);
	}

}
