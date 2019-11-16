package com.productsSimilarityCalc.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.googlecode.jmapper.JMapper;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.view.SimilarProductView;

public class SimilarProductMapper {
	
	private SimilarProductMapper() {
		
	}	
	
	public static List<SimilarProductView> mapToView(List<SimilarProductEntity> similarProductEntityList) {
		List<SimilarProductView> similarProductViewList = new ArrayList<>();
		List<SimilarProductEntity> mostSimilarProductEntityList = similarProductEntityList.stream()
				                                                                          .sorted(Comparator.comparing(SimilarProductEntity::getSimilarity)
				                                                                          .reversed()).limit(3).collect(Collectors.toList());		
		mostSimilarProductEntityList.stream().forEach(similarProductEntity -> {
			JMapper<SimilarProductView,SimilarProductEntity> similarProdMapperViewList = new JMapper<>(SimilarProductView.class,SimilarProductEntity.class);
			similarProductViewList.add(similarProdMapperViewList.getDestination(similarProductEntity));
		});
		return similarProductViewList;
	}
}
