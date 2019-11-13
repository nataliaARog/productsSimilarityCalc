package com.productsSimilarityCalc.enumaration;

import java.util.Optional;

public enum ErrorMessageEnum {
	
	ERROR_MSG_READ_FILE("Impossible to read this file!");
	
	private String errorMessage;
	
	private ErrorMessageEnum(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() { 
	  Optional<String> opErrorMessage =  Optional.ofNullable(errorMessage); 
	  return opErrorMessage.orElse(ParameterEnum.EMPTY.getParameter()); 
	}	
}
