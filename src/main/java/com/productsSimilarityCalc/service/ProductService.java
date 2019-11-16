package com.productsSimilarityCalc.service;

import java.util.List;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.util.GenericException;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Interface that provide the method's signature related to reading and checking ProductEntity
 * Facade pattern applied
 * Making easy to use which is good for maintenance and readability
 * And it hides the complexities for the client (in this case, controllers)
 *  
 */
public interface ProductService {

	public ProductEntityList findProducts() throws GenericException;
	public ProductEntity checkCharacteristcs(ProductEntity product,String[] characteristics);
	public ProductEntity findProduct(int id,List<ProductEntity> productsList) throws GenericException;	
}
