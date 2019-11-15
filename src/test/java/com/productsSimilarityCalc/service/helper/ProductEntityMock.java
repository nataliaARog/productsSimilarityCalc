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
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8363);
		product.setName("VESTIDO CURTO MANGA LONGA LUREX");
		product.setTags(new String[] {"colorido", "metal", "delicado", "estampas", "passeio"});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8080);
		product.setName("VESTIDO CURTO RENDA VISCOSE");
		product.setTags(new String[] {"neutro", "workwear", "moderno", "descolado", "liso", "elastano"});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(7613);
		product.setName("VESTIDO LONGO BABADO");
		product.setTags(new String[] {"casual", "liso", "passeio", "colorido", "boho"});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(7613);
		product.setName("VESTIDO COTTON DOUBLE");
		product.setTags(new String[] {"balada", "liso", "moderno", "descolado"});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8300);
		product.setName("VESTIDO MALHA COM FENDA");
		product.setTags(new String[] {"balada", "metal", "estampas", "moderno"});
		products.add(product);
		
		product = new ProductEntity();
		product.setId(8314);
		product.setName("VESTIDO PLISSADO ACINTURADO");
		product.setTags(new String[] {"casual", "viagem", "delicado"});
		products.add(product);
		
		return products;
	}
	
	public static List<SimilarProductEntity> getSimilarProductsEntityMock() {
		List<SimilarProductEntity> products = new ArrayList<>();
		SimilarProductEntity product = new SimilarProductEntity();
			
		product.setId(8371);
		product.setName("VESTIDO TRICOT CHEVRON");		
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8363);
		product.setName("VESTIDO CURTO MANGA LONGA LUREX");		
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8080);
		product.setName("VESTIDO CURTO RENDA VISCOSE");		
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(7613);
		product.setName("VESTIDO LONGO BABADO");		
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(7613);
		product.setName("VESTIDO COTTON DOUBLE");	
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8300);
		product.setName("VESTIDO MALHA COM FENDA");
		products.add(product);
		
		product = new SimilarProductEntity();
		product.setId(8314);
		product.setName("VESTIDO PLISSADO ACINTURADO");
		products.add(product);
		
		return products;
	}
}
