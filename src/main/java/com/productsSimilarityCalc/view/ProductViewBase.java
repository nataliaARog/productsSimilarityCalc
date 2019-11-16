package com.productsSimilarityCalc.view;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * Base class for ProductView and SimilarProductView
 * They have name and id in common
 *
 */
public class ProductViewBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JMap
	private int id;	
	@JMap
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
