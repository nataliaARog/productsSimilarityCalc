package com.productsSimilarityCalc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.predicate.TagPredicate;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.util.GenericException;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class.getName());	
	
	public ProductEntityList findProducts() throws GenericException {
		ProductEntityList productList = null;		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			ClassPathResource resource = new ClassPathResource("/static/produtos.json");
			InputStream inputStream = resource.getInputStream();			
			productList = mapper.readValue(inputStream,new TypeReference<ProductEntityList>(){});					
			
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
			throw new GenericException(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage());
		} 
		
		return productList;
	}
	
	@Override
	public ProductEntity checkCharacteristcs(ProductEntity product,String[] characteristics) throws GenericException {
		ProductEntity checkedProduct = product;
		int[] tagsVector = new int[20];
		
		IntStream.range(0,  characteristics.length).forEach(i -> {	
			Arrays.stream(product.getTags()).forEach(tag -> {
				TagPredicate.applyTagVector(tagsVector, i, tag, (t) -> t.equals(characteristics[i]));				
			});			      
		});
		
		checkedProduct.setTagsVector(tagsVector);
		return checkedProduct;
	}

	@Override
	public ProductEntity findProduct(int id,List<ProductEntity> productsList) throws GenericException {
		return productsList.stream()
				           .filter(p -> p.getId() == id)
					       .findFirst()
					       .orElseThrow(() -> new GenericException(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage()));
	}	
}
