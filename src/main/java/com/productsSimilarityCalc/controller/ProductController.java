package com.productsSimilarityCalc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.enumaration.ParameterEnum;
import com.productsSimilarityCalc.mapper.ProductMapper;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.util.Characteristics;
import com.productsSimilarityCalc.util.GenericException;
import com.productsSimilarityCalc.view.ProductView;

@RestController
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());
	@Autowired
	private ProductService productService;
	@Autowired
	private HttpSession session;
	
	@GetMapping(path = "/products", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductView>> fetchProducts() {	
		List<ProductView> products = null;
		
		try {
			ProductEntityList productEntityList = productService.findProducts();
			List<ProductEntity> productsEntity = productEntityList.getPoducts();
			
			IntStream.range(0, productsEntity.size()).forEach(i -> {				
				defineCharacteristcsVector(productsEntity, productsEntity.get(i), i);			
			});
			
			products = ProductMapper.mapToView(productsEntity);
			session.setAttribute(ParameterEnum.PRODUCTS.getParameter(), products);
			
		} catch (GenericException e) {
			LOGGER.severe(e.getMessage());
			ProductView productError = new ProductView();
			productError.setName(e.getMessage());
			List<ProductView> productsError = new ArrayList<>();
			productsError.add(productError);
			return new ResponseEntity<>(productsError,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	private void defineCharacteristcsVector(List<ProductEntity> productsEntity, ProductEntity product, int i) {
		try {
			productsEntity.set(i, productService.checkCharacteristcs(productsEntity.get(i), Characteristics.getCharacteristics()));
			
		} catch (GenericException e) {
			LOGGER.severe(e.getMessage());
			ProductView productError = new ProductView();
			productError.setName(e.getMessage());
			List<ProductView> productsError = new ArrayList<>();
			productsError.add(productError);
		}	
	}
}
