package com.productsSimilarityCalc.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.productsSimilarityCalc.init.Init;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class HomeControllerTest {
	
	@InjectMocks
	private HomeController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void callMainTest() throws Exception {
		ModelAndView modelAndView = mockMvc.perform(MockMvcRequestBuilders.get("/productsSimilarity/index"))
																		  .andExpect(MockMvcResultMatchers.view().name("main"))
				                                                          .andExpect(MockMvcResultMatchers.status().isOk())
				                                                          .andReturn().getModelAndView();
		assertTrue(modelAndView.getViewName().equalsIgnoreCase("main"));
	}
}
