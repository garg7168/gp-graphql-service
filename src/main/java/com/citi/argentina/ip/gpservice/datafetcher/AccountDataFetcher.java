package com.citi.argentina.ip.gpservice.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.service.AccountService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AccountDataFetcher implements DataFetcher<List<Account>> {

	@Autowired
	AccountService accountService;

	@Override
	public List<Account> get(DataFetchingEnvironment dataFetchingEnvironment) throws RuntimeException{

		String acctId = dataFetchingEnvironment.getArgument("acctId");
		System.out.println(acctId);
		return accountService.findByAcctId(acctId);
	}
}