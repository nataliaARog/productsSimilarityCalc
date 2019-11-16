package com.productsSimilarityCalc.enumaration;

import java.util.Optional;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Enum containing system error messages 
 * Enum has been chosen beacuse they are type-safety, immutable and use Single pattern as default
 *
 */
public enum ErrorMessageEnum {
	
	ERROR_MSG_READ_FILE("Impossible to read this file!"),
	ERROR_MSG_ARITHMETIC("Problems with calculation!"),
	ERROR_MSG_PRODUCT_NOT_FOUNDC("Product not found!");
	
	private String errorMessage;
	
	private ErrorMessageEnum(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() { 
	  Optional<String> opErrorMessage =  Optional.ofNullable(errorMessage); 
	  return opErrorMessage.orElse(ParameterEnum.EMPTY.getParameter()); 
	}	
}
