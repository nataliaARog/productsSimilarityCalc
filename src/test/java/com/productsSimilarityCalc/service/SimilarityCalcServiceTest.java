package com.productsSimilarityCalc.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.SimilarProductEntity;
import com.productsSimilarityCalc.init.Init;
import com.productsSimilarityCalc.service.helper.ProductEntityMock;
import com.productsSimilarityCalc.service.impl.SimilarityCalcServiceImpl;
import com.productsSimilarityCalc.util.GenericException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class SimilarityCalcServiceTest {
	
	@Mock
	private SimilarityCalcService service;
	private ProductEntity product;
		
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new SimilarityCalcServiceImpl();
		product = ProductEntityMock.getProductEntityMock();
		product.setTagsVector(new int[] {0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,1});
	}
	
	@Test
	public void defineSimilarProductsSuccessTest() throws GenericException {
		given(Mockito.spy(service).defineSimilarProducts(product, ProductEntityMock.getProductsEntityMock())).willReturn(ProductEntityMock.getSimilarProductsEntityMock());
		List<SimilarProductEntity> similarProducts = service.defineSimilarProducts(product, ProductEntityMock.getProductsEntityMock());
		
		SimilarProductEntity product = new SimilarProductEntity();		
		product.setId(8371);
		product.setName("VESTIDO TRICOT CHEVRON");	
		product.setSimilarity(new Double(0.29));
		
		assertTrue(similarProducts.size() > 0);
		assertTrue(similarProducts.stream()
				                  .filter(sp -> sp.getSimilarity() == product.getSimilarity())
				                  .findFirst().isPresent());
	}

}
