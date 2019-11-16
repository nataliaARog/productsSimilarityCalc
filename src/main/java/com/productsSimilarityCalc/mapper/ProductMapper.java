package com.productsSimilarityCalc.mapper;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.JMapper;
import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.view.ProductView;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Abstract superclass for mappers from entities to views.
 * Composite pattern applied.  
 * Both concrete mappers have similar characteristics (mapToView).
 * Singleton pattern applied.
 * This way, one only instance of this class will be created.
 * It is not necessary to create more than one.
 *
 */
public class ProductMapper extends AbstractMapper {
	
	private static final ProductMapper INSTANCE = new ProductMapper();
	
	private ProductMapper() {
		
	}
	
	public static ProductMapper getInstance() {
		return INSTANCE;
	}

	/**
	 * Method that map a list of ProductEntity to a list of ProductView.
	 * JMapper was used to automatize the mapping.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductView> mapToView(List<?> entities) {
		List<ProductView> productViewList = new ArrayList<>();
		List<ProductEntity> productEntities = (List<ProductEntity>) entities;
		productEntities.stream().forEach(productEntity -> {
			JMapper<ProductView,ProductEntity> prodMapperViewList = new JMapper<>(ProductView.class,ProductEntity.class);
			productViewList.add(prodMapperViewList.getDestination(productEntity));
		});
		return productViewList;
	}	
}
