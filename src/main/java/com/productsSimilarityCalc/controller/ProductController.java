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
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.enumaration.ParameterEnum;
import com.productsSimilarityCalc.mapper.ProductMapper;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.util.Characteristics;
import com.productsSimilarityCalc.util.GenericException;
import com.productsSimilarityCalc.view.ProductView;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Restful Controller responsible for bringing the products and send to view
 * OBS: Spring Boot + Spring MVC use as default the MVC design pattern
 *
 */
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
	
	/**
	 * 
	 * @return ResponseEntity<List<ProductView>>
	 * 
	 * This method communicates with service layer to fetch the products, check their characteristics,
	 * save in session, mapping from a entity (json) to a view object and send to view
	 * 
	 */
	@GetMapping(path = "/products", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductView>> fetchProducts() {	
		List<ProductView> products = null;
		
		try {
			ProductEntityList productEntityList = productService.findProducts();
			List<ProductEntity> productsEntity = productEntityList.getPoducts();
			
			IntStream.range(0, productsEntity.size()).forEach(i -> {				
				productsEntity.set(i, productService.checkCharacteristcs(productsEntity.get(i), Characteristics.getCharacteristics()));	
			});
			
			session.setAttribute(ParameterEnum.PRODUCTS.getParameter(), productsEntity);
			products = ProductMapper.getInstance().mapToView(productsEntity);			
			
		} catch (GenericException e) {
			LOGGER.severe(e.getMessage());
			ProductView productError = new ProductView();
			productError.setName(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage());
			List<ProductView> productsError = new ArrayList<>();
			productsError.add(productError);
			return new ResponseEntity<>(productsError,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
