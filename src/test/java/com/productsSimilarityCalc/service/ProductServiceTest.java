package com.productsSimilarityCalc.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.productsSimilarityCalc.entity.ProductEntity;
import com.productsSimilarityCalc.entity.ProductEntityList;
import com.productsSimilarityCalc.init.Init;
import com.productsSimilarityCalc.service.helper.ProductEntityMock;
import com.productsSimilarityCalc.service.impl.ProductServiceImpl;
import com.productsSimilarityCalc.util.Characteristics;
import com.productsSimilarityCalc.util.GenericException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Init.class)
public class ProductServiceTest {
	
	@Mock
	private ProductService service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new ProductServiceImpl();
	}
	
	@Test
	public void findProductsSuccessTest() throws GenericException {
		given(Mockito.spy(service).findProducts()).willReturn(ProductEntityMock.getProductEntityListMock());
		ProductEntityList productEntityList = service.findProducts();
		assertNotNull(productEntityList);
		assertTrue(productEntityList.getPoducts().size() > 0);
	}
	
	@Test
	public void checkCharacteristcs() {
		given(Mockito.spy(service).checkCharacteristcs(ProductEntityMock.getProductEntityMock(), Characteristics.getCharacteristics())).willReturn(ProductEntityMock.getProductEntityMock());
		ProductEntity productEntity = service.checkCharacteristcs(ProductEntityMock.getProductEntityMock(), Characteristics.getCharacteristics());
		assertNotNull(productEntity);
		assertTrue(productEntity.getTagsVector().length == 20);
	}
	
	@Test
	public void findProductSuccessTest() throws GenericException {
		given(Mockito.spy(service).findProduct(7533,ProductEntityMock.getProductsEntityMock())).willReturn(ProductEntityMock.getProductEntityMock());
		ProductEntity productEntity = service.findProduct(7533,ProductEntityMock.getProductsEntityMock());
		assertNotNull(productEntity);
		assertTrue(productEntity.getId() == 7533);
	}
}
