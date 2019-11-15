package com.productsSimilarityCalc.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductEntityList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("products")
	private List<ProductEntity> poducts;

	public List<ProductEntity> getPoducts() {
		return poducts;
	}

	public void setPoducts(List<ProductEntity> poducts) {
		this.poducts = poducts;
	}	
}
