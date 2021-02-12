package com.citi.argentina.ip.gpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.argentina.ip.gpservice.model.Response;
import com.citi.argentina.ip.gpservice.util.GraphQlUtility;
import com.citi.argentina.ip.gpservice.util.ResponseMapping;

import graphql.ExecutionResult;

@RequestMapping("/argentina/gpservice")
@RestController
public class AcountResourceController {

	@Autowired
	private GraphQlUtility graphQlUtility;
	@Autowired
	ResponseMapping responseMapping;
	Response response = null;

	@PostMapping
	public ResponseEntity<Object> accountMethods(@RequestBody String query) {

		ExecutionResult result = graphQlUtility.getGraphQL().execute(query);
		//response = responseMapping.resultToResponse(result);
		System.out.println("after response ");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
