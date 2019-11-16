package com.productsSimilarityCalc.view;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * SimilarProductView class that represent the similar product that is showing on screen
 * It has the similarity of a product
 * ProductViewBase's subclass
 * 
 */
public class SimilarProductView extends ProductViewBase implements Serializable {

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
