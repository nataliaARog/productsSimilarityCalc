package com.productsSimilarityCalc.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.productsSimilarityCalc.init.Init;
import com.productsSimilarityCalc.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class ProductServiceTest {
	
	@InjectMocks
	private ProductService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new ProductServiceImpl();
	}
	
	@Test
	public void defineSimilarProductsSuccessTest() {
		
	}

}
