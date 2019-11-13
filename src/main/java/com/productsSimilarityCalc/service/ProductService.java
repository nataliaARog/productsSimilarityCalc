package com.productsSimilarityCalc.service;

import com.productsSimilarityCalc.entity.ProductEntitytList;
import com.productsSimilarityCalc.util.GenericException;

public interface ProductService {

	public ProductEntitytList findProducts() throws GenericException;
}
