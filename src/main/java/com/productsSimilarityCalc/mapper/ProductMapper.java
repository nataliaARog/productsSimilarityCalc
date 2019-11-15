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
	
	public static ProductEntity mapToEntity(ProductView productView) {
		JMapper<ProductEntity,ProductView> prodMapperEntity = new JMapper<>(ProductEntity.class,ProductView.class);
		return prodMapperEntity.getDestination(productView);
	}
	
	public static List<ProductView> mapToView(List<ProductEntity> productEntityList) {
		List<ProductView> productViewList = new ArrayList<>();
		productEntityList.stream().forEach(productEntity -> {
			JMapper<ProductView,ProductEntity> prodMapperViewList = new JMapper<>(ProductView.class,ProductEntity.class);
			productViewList.add(prodMapperViewList.getDestination(productEntity));
		});
		return productViewList;
	}
	
	public static List<ProductEntity> mapToEntity(List<ProductView> productViewList) {
		List<ProductEntity> productEntityList = new ArrayList<>();
		productViewList.stream().forEach(productView -> {
			JMapper<ProductEntity,ProductView> prodMapperEntityList = new JMapper<>(ProductEntity.class,ProductView.class);
			productEntityList.add(prodMapperEntityList.getDestination(productView));
		});
		return productEntityList;
	}

}
