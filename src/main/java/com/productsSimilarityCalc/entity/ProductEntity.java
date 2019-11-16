package com.productsSimilarityCalc.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * ProductEntity class that represent the Json object product 
 * ProductBaseEntity's subclass
 * It has Json properties (represent a json object)
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity extends ProductBaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JMap
	@JsonProperty("tags")
	private String[] tags;
	@JMap
	private int[] tagsVector;
	
	public String[] getTags() {
		return tags;
	}
	
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	public int[] getTagsVector() {
		return tagsVector;
	}
	
	public void setTagsVector(int[] tagsVector) {
		this.tagsVector = tagsVector;
	}		
}
