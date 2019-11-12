package com.productsSimilarityCalc.util;

public class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericException() { super(); }
	public GenericException(String message) { super(message); }
	public GenericException(String message, Throwable cause) { super(message, cause); }
	public GenericException(Throwable cause) { super(cause); }
}
