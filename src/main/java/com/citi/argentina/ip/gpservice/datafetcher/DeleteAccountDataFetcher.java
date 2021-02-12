package com.citi.argentina.ip.gpservice.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.service.AccountService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class DeleteAccountDataFetcher implements DataFetcher<List<Account>> {

	@Autowired
	AccountService accountservice;

	@Override
	public List<Account> get(DataFetchingEnvironment environment) throws RuntimeException{

		String acctid = environment.getArgument("acctId");
		return accountservice.deleteDetails(acctid);
	}
}
