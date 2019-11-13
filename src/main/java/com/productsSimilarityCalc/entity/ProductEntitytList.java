package com.productsSimilarityCalc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductEntitytList {

	@JsonProperty("products")
	private List<ProductEntity> poducts;

	public List<ProductEntity> getPoducts() {
		return poducts;
	}

	public void setPoducts(List<ProductEntity> poducts) {
		this.poducts = poducts;
	}	
}
