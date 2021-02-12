package com.citi.argentina.ip.gpservice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.citi.argentina.ip.gpservice.exceptions.NoSuchAccountException;
import com.citi.argentina.ip.gpservice.model.Account;

public interface AccountService {

	Page<Account> findAll(int skip, int first);

	List<Account> findByAcctId(String acctId) throws RuntimeException;
	/*	List<Account> saveDetails(String acctName,
		                          Float amount,
		                          String accountType,
		                          String status,
		                          Audit auditObj,
		                          BankDetails bankDetailsObj,
		                          Contacts contactObj,
		                          Address addressObj);*/

	List<Account> saveDetails(Account accountObj);

	List<Account> updateDetails(Account accountObj) throws RuntimeException ;

	List<Account> deleteDetails(String acctid) throws RuntimeException;
}
