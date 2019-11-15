package com.productsSimilarityCalc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.util.GenericException;

@Service
public interface SimilarityCalcService {

	public List<SimilarProductEntity> defineSimilarProducts(ProductEntity product,List<ProductEntity> productsList) throws GenericException;
}
