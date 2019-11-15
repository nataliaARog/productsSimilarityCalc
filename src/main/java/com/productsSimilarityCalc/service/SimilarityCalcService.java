package com.productsSimilarityCalc.service;

import java.util.List;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.util.GenericException;

public interface SimilarityCalcService {

	public List<SimilarProductEntity> defineSimilarProducts(ProductEntity product,List<ProductEntity> productsList) throws GenericException;
}
