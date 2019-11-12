package com.productsSimilarityCalc.service;

import com.productsSimilarityCalc.entity.ProducEntitytList;
import com.productsSimilarityCalc.util.GenericException;

public interface ProductService {

	//https://goo.gl/86o0pL​ -> serviço
	public ProducEntitytList findProducts() throws GenericException;
	public int[] findCharacteristics() throws GenericException;
}
