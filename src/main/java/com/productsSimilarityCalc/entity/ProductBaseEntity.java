package com.productsSimilarityCalc.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * Base class for ProductEntity and SimilarProductEntity
 * It has Json properties (represent a json object)
 * They have name and id in common
 *
 */
public class ProductBaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JMap
	@JsonProperty("id")
	private int id;	
	@JMap
	@JsonProperty("name")
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
