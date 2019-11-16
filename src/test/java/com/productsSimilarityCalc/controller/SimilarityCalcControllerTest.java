package com.productsSimilarityCalc.controller;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productsSimilarityCalc.enumaration.ParameterEnum;
import com.productsSimilarityCalc.init.Init;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.service.SimilarityCalcService;
import com.productsSimilarityCalc.service.helper.ProductEntityMock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class SimilarityCalcControllerTest {
	
	@InjectMocks
	private SimilarityCalcController controller;
	@Mock
	private ProductService productService;
	@Mock
	private SimilarityCalcService service;
	@Mock
	private HttpSession session;
	@Mock
	private ObjectMapper mapper;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {	
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	@Test
	public void calculateAndReturnSuccessTest() throws Exception {
		Mockito.when(session.getAttribute(ParameterEnum.PRODUCTS.getParameter())).thenReturn(ProductEntityMock.getProductsEntityMock());
		Mockito.when(productService.findProduct(7533,ProductEntityMock.getProductsEntityMock())).thenReturn(ProductEntityMock.getProductEntityMock());
		Mockito.when(service.defineSimilarProducts(ProductEntityMock.getProductEntityMock(), ProductEntityMock.getProductsEntityMock())).thenReturn(ProductEntityMock.getSimilarProductsEntityMock());
		
		mockMvc.perform(MockMvcRequestBuilders.post("/similarities")
				                              .param("id", "7533"))
				                              .andExpect(MockMvcResultMatchers.status().isOk())
                                              .andReturn()
                                              .getResponse()
                                               .getContentAsString();
		
		
	}

}
