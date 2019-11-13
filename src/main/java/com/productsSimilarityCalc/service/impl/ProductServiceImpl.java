package com.productsSimilarityCalc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productsSimilarityCalc.entity.ProductEntitytList;
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.util.GenericException;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class.getName());
	
	public ProductEntitytList findProducts() throws GenericException {
		ProductEntitytList productList = null;
		InputStream inputStream = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<ProductEntitytList> typeReference = new TypeReference<ProductEntitytList>(){};
		
		try {
			inputStream = TypeReference.class.getResourceAsStream("/static/produtos.json");
			productList = mapper.readValue(inputStream,typeReference);			
			
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
			throw new GenericException(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage());
		} 
		
		return productList;
	}	
}
