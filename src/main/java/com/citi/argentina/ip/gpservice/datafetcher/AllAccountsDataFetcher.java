package com.citi.argentina.ip.gpservice.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.service.AccountService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllAccountsDataFetcher implements DataFetcher<Page<Account>> {

	private final AccountService accountservice;

	@Autowired
	AllAccountsDataFetcher(AccountService accountservice) {

		this.accountservice = accountservice;
	}

	@Override
	public Page<Account> get(DataFetchingEnvironment dataFetchingEnvironment) {

		int skip = dataFetchingEnvironment.getArgument("skip");
		int first = dataFetchingEnvironment.getArgument("first");
		return accountservice.findAll(skip, first);
	}
}
