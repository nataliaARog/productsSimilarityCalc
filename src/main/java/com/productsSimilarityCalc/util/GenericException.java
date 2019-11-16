package com.productsSimilarityCalc.util;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Custom exception for the application
 * It provides information or functionality that is not part of Java’s standard exceptions
 *
 */
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
