package com.productsSimilarityCalc.entity;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * SimilarProductEntity class that represent the similar product as a result of the calculation
 * It has the similarity of a product
 * ProductBaseEntity's subclass
 *  
 */
public class SimilarProductEntity extends ProductBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JMap
	private double similarity;

	public double getSimilarity() {
		return similarity;
	}

	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
}
