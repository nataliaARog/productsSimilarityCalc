package com.productsSimilarityCalc.service;

import java.util.List;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.util.GenericException;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Interface that provide the method's signature related to reading and checking SimilarProductEntity
 * Facade pattern applied
 * Making easy to use which is good for maintenance and readability
 * And it hides the complexities for the client (in this case, controllers)
 *  
 */
public interface SimilarityCalcService {

	public List<SimilarProductEntity> defineSimilarProducts(ProductEntity product,List<ProductEntity> productsList) throws GenericException;
}
