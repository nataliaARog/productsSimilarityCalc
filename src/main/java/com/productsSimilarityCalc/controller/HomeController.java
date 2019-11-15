package com.productsSimilarityCalc.controller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GetMapping("/")
	public String chamaIndex() {
		return "index";
	}

}
