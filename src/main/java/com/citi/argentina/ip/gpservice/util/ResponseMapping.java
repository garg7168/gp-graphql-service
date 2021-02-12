
package com.citi.argentina.ip.gpservice.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.ExecutionResult;

@Component
public class ResponseMapping {

	@Autowired
	ObjectMapper mapper;
	Response response = new Response();

	public Response resultToResponse(ExecutionResult result) {

		try {
			String jsonString = null;
			String nodeStringKey = null;
			String nodeStringValue = null;
			System.out.println("result.getErrors()" + result.getErrors());

			if(result.getErrors().size()>0){
				List<Object> obj = new ArrayList<>();
				obj.add(result.getErrors().get(0).getMessage());
				response.setData(null);	//graphql support data and error both in response for a request.
				response.setError(obj);
			}else {
				//if (result.getErrors().isEmpty()) {
				jsonString = mapper.writeValueAsString(result.getData());
				LinkedHashMap<String, Object> resultData = result.getData();
				nodeStringKey = resultData.keySet().toArray()[0].toString();
				//}
				switch (nodeStringKey) {
					case "allAccounts":
						nodeStringValue = mapper.readTree(jsonString).path("allAccounts").toString();
						break;
					case "account":
						nodeStringValue = mapper.readTree(jsonString).path("account").toString();
						break;
					case "createAccount":
						nodeStringValue = mapper.readTree(jsonString).path("createAccount").toString();
						break;
					case "updateAccount":
						nodeStringValue = mapper.readTree(jsonString).path("updateAccount").toString();
						break;
					case "deleteAccount":
						nodeStringValue = mapper.readTree(jsonString).path("deleteAccount").toString();
						break;
				}
				List<Object> obj = mapper.readValue(nodeStringValue, new TypeReference<List<Object>>() {
				});
				//response = new Response();
				response.setData(obj);
				response.setError(null);  //graphql support data and error both in response.
			}
			//response.setError(result.getErrors());
			System.out.println("jsonString is " + jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
}