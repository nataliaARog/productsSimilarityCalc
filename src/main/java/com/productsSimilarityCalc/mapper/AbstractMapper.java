package com.productsSimilarityCalc.mapper;

import java.util.List;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Abstract superclass for mappers from entities to views.
 * Composite pattern applied.  
 * Both concrete mappers have similar characteristics (mapToView).
 * Method mapToview is generic, allowing the subclasses defining its behaviour and entries as necessary.
 *
 */
public abstract class AbstractMapper {

	public abstract List<?> mapToView(List<?> entities);
}
