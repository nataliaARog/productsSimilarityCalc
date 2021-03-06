package com.productsSimilarityCalc.service.helper;

import java.util.ArrayList;
import java.util.List;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.entity.SimilarProductEntity;

public class ProductEntityMock {

	private ProductEntityMock() {
		
	}
	
	public static ProductEntityList getProductEntityListMock() {
		ProductEntityList productList = new ProductEntityList();
		productList.setPoducts(getProductsEntityMock());
		return productList;
	}
	
	public static List<ProductEntity> getProductsEntityMock() {
		List<ProductEntity> products = new ArrayList<>();
		ProductEntity product = new ProductEntity();
			
		product.setId(8371);
		product.setName("VESTIDO TRICOT CHEVRON");
		product.setTags(new String[] {"balada", "neutro", "delicado", "festa"});
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8363);
		product.setName("VESTIDO CURTO MANGA LONGA LUREX");
		product.setTags(new String[] {"colorido", "metal", "delicado", "estampas", "passeio"});
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8080);
		product.setName("VESTIDO CURTO RENDA VISCOSE");
		product.setTags(new String[] {"neutro", "workwear", "moderno", "descolado", "liso", "elastano"});
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,1});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(7613);
		product.setName("VESTIDO LONGO BABADO");
		product.setTags(new String[] {"casual", "liso", "passeio", "colorido", "boho"});
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,1});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(7533);
		product.setName("VESTIDO COTTON DOUBLE");
		product.setTags(new String[] {"balada", "liso", "moderno", "descolado"});
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,1});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8300);
		product.setName("VESTIDO MALHA COM FENDA");
		product.setTags(new String[] {"balada", "metal", "estampas", "moderno"});
		product.setTagsVector(new int[] {0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,1});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8314);
		product.setName("VESTIDO PLISSADO ACINTURADO");
		product.setTags(new String[] {"casual", "viagem", "delicado"});
		product.setTagsVector(new int[] {0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0});
		products.add(product);
		
		return products;
	}
	
	public static List<SimilarProductEntity> getSimilarProductsEntityMock() {
		List<SimilarProductEntity> products = new ArrayList<>();
		SimilarProductEntity product = new SimilarProductEntity();
			
		product.setId(8371);
		product.setName("VESTIDO TRICOT CHEVRON");	
		product.setSimilarity(new Double(0.29));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8363);
		product.setName("VESTIDO CURTO MANGA LONGA LUREX");
		product.setSimilarity(new Double(0.18));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8080);
		product.setName("VESTIDO CURTO RENDA VISCOSE");	
		product.setSimilarity(new Double(0.07));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(7613);
		product.setName("VESTIDO LONGO BABADO");
		product.setSimilarity(new Double(0.26));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(7533);
		product.setName("VESTIDO COTTON DOUBLE");	
		product.setSimilarity(new Double(0.15));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8300);
		product.setName("VESTIDO MALHA COM FENDA");
		product.setSimilarity(new Double(0.04));
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8314);
		product.setName("VESTIDO PLISSADO ACINTURADO");
		product.setSimilarity(new Double(0.03));
		products.add(product);
		
		return products;
	}
	
	public static ProductEntity getProductEntityMock() {
		ProductEntity product = new ProductEntity();		
		product.setId(7533);
		product.setName("VESTIDO COTTON DOUBLE");
		product.setTags(new String[] {"balada", "liso", "moderno", "descolado"});
		return product;
	}
}
