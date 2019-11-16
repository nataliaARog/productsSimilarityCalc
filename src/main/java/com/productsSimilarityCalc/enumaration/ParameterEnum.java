package com.productsSimilarityCalc.enumaration;

import java.util.Optional;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Enum containing parameters used for all
 * Enum has been chosen beacuse they are type-safety, immutable and use Single pattern as default
 *
 */
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
