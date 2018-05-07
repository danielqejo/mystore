package com.example.mystore.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mystore.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-TEST.properties")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductControllerTest {
	
	@Autowired
	private ObjectMapper objMapper;
	
	@Autowired
	private MockMvc mvc;
	
	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnMoreThanFiveProducts() throws Exception {
		String contentAsString = 
				this.mvc.perform(get("/product/list"))
					.andReturn().getResponse().getContentAsString();
		
		List<Product> resultList = objMapper.readValue(contentAsString, List.class);
		
		assertTrue(resultList.size() > 5);
	}
	
	@Test
	public void shouldReturnNoProduct() throws Exception {
		String contentAsString = 
				this.mvc.perform(get("/product/by-id/8796093054977"))
					.andReturn().getResponse().getContentAsString();
		
		assertEquals(contentAsString, "");
	}
	

}
