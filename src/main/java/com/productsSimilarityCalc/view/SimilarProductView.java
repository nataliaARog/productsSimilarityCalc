package com.productsSimilarityCalc.view;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

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
