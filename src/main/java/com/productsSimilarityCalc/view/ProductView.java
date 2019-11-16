package com.productsSimilarityCalc.view;

import java.io.Serializable;

import com.googlecode.jmapper.annotations.JMap;

/**
 * 
 * @author Natalia Avelino Rogerio
 * ProductView class that represent the product that is showing on screen
 * ProductViewBase's subclass
 * 
 */
public class ProductView extends ProductViewBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
		
	@JMap
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
