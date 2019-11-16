package com.productsSimilarityCalc.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.googlecode.jmapper.JMapper;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.view.SimilarProductView;

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
public class SimilarProductMapper extends AbstractMapper {
	
	private static final SimilarProductMapper INSTANCE = new SimilarProductMapper();
	
	private SimilarProductMapper() {
		
	}	
	
	public static SimilarProductMapper getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Method that map a list of SimilarProductEntity to a list of SimilarProductView.
	 * JMapper was used to automatize the mapping.
	 * During the mapping, it is checked the three most similar products and passed to view.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SimilarProductView> mapToView(List<?> entities) {
		List<SimilarProductEntity> similarProductEntityList = (List<SimilarProductEntity>) entities;
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
