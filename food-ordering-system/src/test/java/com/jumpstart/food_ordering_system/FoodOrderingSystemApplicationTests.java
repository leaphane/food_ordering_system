package com.jumpstart.food_ordering_system;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

class FoodOrderingSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testFoodByIdEndpoint(){

		HttpResponse<String> response = Unirest.get("http://localhost:8080/api/category/2")
				.asString();

		assertEquals(200, response.getStatus());

		String body = response.getBody();

		assertTrue(body.contains("\"id\":2"));
		assertTrue(body.contains("\"name\":\"Fast food\""));

	}

	@Test
	void testAllCategoriesEndpoint() {

		HttpResponse<JsonNode> response =
				Unirest.get("http://localhost:8080/api/category/allCategories")
						.asJson();

		assertEquals(200, response.getStatus());

		var categories = response.getBody().getArray();//n.b

		assertEquals(4, categories.length());

		assertEquals(1, categories.getJSONObject(0).getInt("id"));
		assertEquals("Pizza", categories.getJSONObject(0).getString("name"));

		assertEquals(2, categories.getJSONObject(1).getInt("id"));
		assertEquals("Fast food", categories.getJSONObject(1).getString("name"));

	}


}
