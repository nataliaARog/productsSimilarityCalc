package com.productsSimilarityCalc.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("tags")
	private Set<String> tags;
	private int[] tagsVector;
	
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
	
	public Set<String> getTags() {
		return tags;
	}
	
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public int[] getTagsVector() {
		return tagsVector;
	}
	
	public void setTagsVector(int[] tagsVector) {
		this.tagsVector = tagsVector;
	}		
}
