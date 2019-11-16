package com.productsSimilarityCalc.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Initialization and configuration class for Spring Boot Application
 * It has been configured resources folder for statics (CSS and Javascript/JQuery)
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.productsSimilarityCalc.controller","com.productsSimilarityCalc.service","com.productsSimilarityCalc.serviceimpl"})
public class Init extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String... args) {
        SpringApplication.run(Init.class, args);
    }    
    
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
