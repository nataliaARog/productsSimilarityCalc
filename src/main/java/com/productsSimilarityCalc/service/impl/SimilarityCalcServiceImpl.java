package com.productsSimilarityCalc.service.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.AtomicDouble;
import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.service.SimilarityCalcService;
import com.productsSimilarityCalc.util.GenericException;

@Service
public class SimilarityCalcServiceImpl implements SimilarityCalcService {
	
	private static final Logger LOGGER = Logger.getLogger(SimilarityCalcServiceImpl.class.getName());

	@Override
	public List<SimilarProductEntity> defineSimilarProducts(ProductEntity product, List<ProductEntity> productsList)
			throws GenericException {
		List<SimilarProductEntity> similarProductsList = new ArrayList<>();		
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator('.');
		DecimalFormat formatter = new DecimalFormat("#0.00",decimalFormatSymbols);
		int[] foundTagsVector = product.getTagsVector();
		int[] tagsVector = new int[20];
		AtomicDouble diff = new AtomicDouble(0.0);
		AtomicDouble sum = new AtomicDouble(0.0);
		AtomicDouble d = new AtomicDouble(0.0);
		
		try {
			productsList.stream().forEach(p -> {
				SimilarProductEntity similarProduct = new SimilarProductEntity();
				
				IntStream.range(0,foundTagsVector.length).forEach(i -> {
					diff.set(foundTagsVector[i] - tagsVector[i]);
					sum.addAndGet(Math.pow(diff.get(),2));
				});			
				
				d.set(Math.sqrt(sum.get()));
				similarProduct.setId(p.getId());
				similarProduct.setName(p.getName());
				similarProduct.setSimilarity(new Double(formatter.format(1/(1+d.get()))));
				similarProductsList.add(similarProduct);
			});
			
		} catch(ArithmeticException e) {
			LOGGER.severe(e.getMessage());
			throw new GenericException(ErrorMessageEnum.ERROR_MSG_ARITHMETIC.getErrorMessage());
		}
		
		return similarProductsList;
	}

}
