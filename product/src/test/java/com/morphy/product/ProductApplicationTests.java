package com.morphy.product;

import static io.restassured.RestAssured.*;
import com.morphy.product.controller.model.ProductRequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductApplicationTests {

	@Container
	final static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

	@Autowired
	private MockMvc mock;
	void contextLoads() {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry){

		registry.add("spring.data.mongodb.url",mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	public void createProduct() throws Exception {
		mock.perform(MockMvcRequestBuilders.post("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(productRequest())))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void getAllProducts() throws Exception {
		String val= mock.perform(MockMvcRequestBuilders.get("/api/product")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn()
				.getResponse()
				.getContentAsString();
  System.out.println(val);

	}

	private ProductRequest productRequest() {
	return
		ProductRequest.builder()
				.id("TestX")
				.productId(1)
				.name("Test X")
				.description("Test Create")
				.price(new BigDecimal(1000.00))
				.build();
	}


}
