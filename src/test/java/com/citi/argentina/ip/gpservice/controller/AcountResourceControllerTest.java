package com.citi.argentina.ip.gpservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

@SpringBootTest
@RunWith(SpringRunner.class)
//@PropertySource("classpath:application.properties")
@TestPropertySource(properties = {"CONFIG_DIR=" + "src/main/resources/cloud_vm/DEV"})
public class AcountResourceControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void AccountListSuccess() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:27017/argentina/gpservice";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
    }
}
	/*private static final OkHttpClient client = new OkHttpClient();
	// Given
	String graphqlPayload = "{" +
			"allAccounts{" +
			" id" +
			" acctId" +
			"}}";*/
	/*private final String graphqlUri = "http://localhost:8080/argentina/gpservice";

	private okhttp3.Response prepareResponse(String graphqlPayload) throws IOException {
		RequestBody body = RequestBody.create(okhttp3.MediaType.get("application/json; charset=utf-8"), graphqlPayload);
		Request request = new Request.Builder().url(graphqlUri).post(body).build();
		return client.newCall(request).execute();
	}

	@Test
	public void testGraphqlWithFile() throws IOException {
		// Read a graphql file
		File file = new File("src/main/resources/account.graphql");

		// Create a variables to pass to the graphql query
		ObjectNode variables = new ObjectMapper().createObjectNode();
		variables.put("acctId", "CITI001123");

		// Now parse the graphql file to a request payload string
		String graphqlPayload = GraphqlTemplate.parseGraphql(file, variables);

		// Build and trigger the request
		Response response = prepareResponse(graphqlPayload);

		Assert.assertEquals(String.valueOf(response.code()), 200, "Response Code Assertion");

		String jsonData = response.body().string();
		JsonNode jsonNode = new ObjectMapper().readTree(jsonData);
		Assert.assertEquals(jsonNode.get("data").get("allAccounts").get("acctId").asText(), "CITI001123");
	}

	@Test
	public void findAllTest() throws Exception {
		// Given
		String query = "{" +
				"allAccounts{" +
				" id" +
				" acctId" +
				"}}";

		// When
		ResultActions postResult = performGraphQlPost(query);

		// Then
		postResult.andExpect(status().isOk())
				.andExpect(jsonPath("$.errors").doesNotExist());
	}

	private ResultActions performGraphQlPost(String query) throws Exception {
		return performGraphQlPost(query, null);
	}

	private ResultActions performGraphQlPost(String query, Map variables) throws Exception {
		return mockMvc.perform(post("http://localhost:8080/argentina/gpservice")
				.contentType(MediaType.APPLICATION_JSON)
				.content(generateRequest(query, variables))
		);
	}

	private String generateRequest(String query, Map variables) throws JSONException {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("query", query);

		if (variables != null) {
			jsonObject.put("variables", Collections.singletonMap("input", variables));
		}

		return jsonObject.toString();
	}
}*/