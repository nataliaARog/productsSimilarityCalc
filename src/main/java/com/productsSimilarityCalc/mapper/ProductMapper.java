package com.productsSimilarityCalc.mapper;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.jmapper.JMapper;
import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.view.ProductView;

public class ProductMapper {
	
	private ProductMapper() {
		
	}
	
	public static ProductView mapToView(ProductEntity productEntity) {
		JMapper<ProductView,ProductEntity> prodMapperView = new JMapper<>(ProductView.class,ProductEntity.class);
		return prodMapperView.getDestination(productEntity);
	}
	
	public static List<ProductView> mapToView(List<ProductEntity> productEntityList) {
		List<ProductView> productViewList = new ArrayList<>();
		productEntityList.stream().forEach(productEntity -> {
			JMapper<ProductView,ProductEntity> prodMapperViewList = new JMapper<>(ProductView.class,ProductEntity.class);
			productViewList.add(prodMapperViewList.getDestination(productEntity));
		});
		return productViewList;
	}
}
