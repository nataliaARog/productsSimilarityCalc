package com.productsSimilarityCalc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.enumaration.ErrorMessageEnum;
import com.productsSimilarityCalc.enumaration.ParameterEnum;
import com.productsSimilarityCalc.mapper.SimilarProductMapper;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.service.SimilarityCalcService;
import com.productsSimilarityCalc.util.GenericException;
import com.productsSimilarityCalc.view.SimilarProductView;

/**
 * 
 * @author Natalia Avelino Rogerio
 * 
 * Restful Controller responsible calculate and define a list with three most similar products,
 * finding the product the provided id
 * OBS: Spring Boot + Spring MVC use as default the MVC design pattern
 *
 */
@RestController
public class SimilarityCalcController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SimilarityCalcService similarityCalcService;
	@Autowired
	private HttpSession session;
	
	/**
	 * 
	 * @return ResponseEntity<List<ProductView>>
	 * 
	 * This method communicates with service layer find in session the product by id provided by view,
	 * calculate and define similar products, map the entities to a list with three most similar products,
	 * sending to view 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(path = "/similarities", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SimilarProductView>> calculateAndReturn(@RequestParam("id") int id) {	
		List<SimilarProductView> similarProducts = null;
		List<SimilarProductEntity> similarProductsEntity = null;
		ProductEntity product = null;
		List<ProductEntity> productsEntity = null;
		
		try {	
			productsEntity = (List<ProductEntity>) session.getAttribute(ParameterEnum.PRODUCTS.getParameter());
			product = productService.findProduct(id,productsEntity);
			similarProductsEntity = similarityCalcService.defineSimilarProducts(product,productsEntity);
			similarProducts = SimilarProductMapper.getInstance().mapToView(similarProductsEntity);
			
		} catch (GenericException e) {
			LOGGER.severe(e.getMessage());
			SimilarProductView similarProductError = new SimilarProductView();
			similarProductError.setName(ErrorMessageEnum.ERROR_MSG_READ_FILE.getErrorMessage());
			List<SimilarProductView> similarProductsError = new ArrayList<>();
			similarProductsError.add(similarProductError);
			return new ResponseEntity<>(similarProductsError,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<List<SimilarProductView>>(similarProducts,HttpStatus.OK);
	}

}
