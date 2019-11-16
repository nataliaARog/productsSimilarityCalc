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
import com.productsSimilarityCalc.init.Init;
import com.productsSimilarityCalc.service.ProductService;
import com.productsSimilarityCalc.service.helper.ProductEntityMock;
import com.productsSimilarityCalc.util.GenericException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class ProductControllerTest {
	
	@InjectMocks
	private ProductController controller;
	@Mock
	private ProductService service;
	@Mock
	private ObjectMapper mapper;
	@Mock
	private HttpSession session;
	
	private MockMvc mockMvc;

	@Before
	public void init() {	
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void fetchProductsSuccessTest() throws Exception {
		Mockito.when(service.findProducts()).thenReturn(ProductEntityMock.getProductEntityListMock());
		Mockito.when(service.checkCharacteristcs(Mockito.any(), Mockito.any())).thenReturn(ProductEntityMock.getProductEntityMock());
		Mockito.doNothing().when(session).setAttribute(Mockito.anyString(), Mockito.any());	
		
		mockMvc.perform(MockMvcRequestBuilders.get("/products"))
				                              .andExpect(MockMvcResultMatchers.status().isOk());		
	}
	
	@Test
	public void fetchProductsErrorTest() throws Exception {
		Mockito.when(service.findProducts()).thenThrow(new GenericException("Error!"));
		Mockito.when(service.checkCharacteristcs(Mockito.any(), Mockito.any())).thenReturn(ProductEntityMock.getProductEntityMock());
		Mockito.doNothing().when(session).setAttribute(Mockito.anyString(), Mockito.any());	
		
		mockMvc.perform(MockMvcRequestBuilders.get("/products"))
				                              .andExpect(MockMvcResultMatchers.status().is4xxClientError());		
	}

}
