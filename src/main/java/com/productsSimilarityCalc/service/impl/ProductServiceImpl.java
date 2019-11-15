package com.productsSimilarityCalc.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.util.Characteristics;
import com.productsSimilarityCalc.util.GenericException;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class.getName());	
	
	public ProductEntityList findProducts() throws GenericException {
		ProductEntityList productList = null;	
		int[] tagsVector = new int[20];		 
		TypeReference<ProductEntityList> typeReference = new TypeReference<ProductEntityList>(){};
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			String[] characteristics = Characteristics.getCharacteristics();
			InputStream inputStream = new FileInputStream("/static/produtos.json");
			productList = mapper.readValue(inputStream,typeReference);
			
			productList.getPoducts().stream().forEach(product -> {
				IntStream.range(0,  characteristics.length).forEach(i -> {	
					Arrays.stream(product.getTags())
					      .filter(t -> characteristics[i].equals(t))
					      .findAny().ifPresent(c -> {tagsVector[i] = 1;});
				});
				product.setTagsVector(tagsVector);
			});			
			
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
			throw new GenericException(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage());
		} 
		
		return productList;
	}

	@Override
	public ProductEntity findProduct(int id,List<ProductEntity> productsList) throws GenericException {
		return productsList.stream()
				           .filter(p -> p.getId() == id)
					       .findFirst()
					       .orElseThrow(() -> new GenericException(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage()));
	}
}
