package com.productsSimilarityCalc.service;

import java.util.List;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.util.GenericException;

public interface ProductService {

	public ProductEntityList findProducts() throws GenericException;
	public ProductEntity findProduct(int id,List<ProductEntity> productsList) throws GenericException;	
}
