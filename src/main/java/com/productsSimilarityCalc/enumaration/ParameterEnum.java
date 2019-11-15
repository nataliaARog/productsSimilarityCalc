package com.productsSimilarityCalc.enumaration;

import java.util.Optional;

public enum ParameterEnum {	
	
	
	EMPTY(""),
	PRODUCTS("products");
	
	private String parametro;
	
	private ParameterEnum(String parametro) {
		this.parametro = parametro;
	}

	public String getParameter() {
		Optional<String> opParametro = Optional.ofNullable(parametro);
		return opParametro.orElse("");
	}	

}
