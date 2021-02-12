package com.citi.argentina.ip.gpservice.datafetcher;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.exceptions.NoSuchAccountException;
import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UpdateAccountDataFetcher implements DataFetcher<List<Account>> {

	@Autowired
	AccountService accountservice;
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<Account> get(DataFetchingEnvironment environment) throws RuntimeException{

		Account accountObj = null;
		Map<String, Object> inputData = environment.getArguments();
		System.out.println("inputData is :" + inputData);
		final ObjectMapper mapper = new ObjectMapper();
		accountObj = mapper.convertValue(inputData, Account.class);
		/*Integer pid = environment.getArgument("personId");
		String name = environment.getArgument("name");
		Integer contactNumber = environment.getArgument("contactNumber");
		String email = environment.getArgument("email");
		String address = environment.getArgument("address");
		Integer zip = environment.getArgument("zip");
		Float amount = ((Double) environment.getArgument("amount")).floatValue();
		System.out.println("value2:" + ((Double) environment.getArgument("amount")).floatValue());
		String accountType = environment.getArgument("accountType");
		Boolean status = environment.getArgument("status");
		LocalDate createdDate1 = environment.getArgument("createdDate");
		Date createdDate = java.sql.Date.valueOf(createdDate1);
		//Date createdDate = Date.from(createdDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		*/ return accountservice.updateDetails(accountObj);
	}
}
