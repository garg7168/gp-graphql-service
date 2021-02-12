package com.citi.argentina.ip.gpservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.citi.argentina.ip.gpservice.exceptions.NoSuchAccountException;
import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.model.Response;
import com.citi.argentina.ip.gpservice.repository.AccountRepository;
import com.citi.argentina.ip.gpservice.util.AutoGenerate;
import com.citi.argentina.ip.gpservice.util.MergeObject;
import com.citi.argentina.ip.gpservice.util.OffsetBasedPageRequest;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AutoGenerate autoGenerate;
	private final AccountRepository accountRepository;

	@Autowired
	AccountServiceImpl(AccountRepository accountRepository) {

		this.accountRepository = accountRepository;
	}

	Response response = null;

	@Override
	public Page<Account> findAll(int skip, int first) {

		return accountRepository.findAll(new OffsetBasedPageRequest(skip, first));
	}

	@Override
	public List<Account> findByAcctId(String acctid) throws RuntimeException{

		Account accountobj = null;
		ArrayList<Account> al = new ArrayList<>();
		Optional<Account> account = this.accountRepository.findByAcctId(acctid);
		if (account.isPresent()) {
			accountobj = account.get();
		}
		if (accountobj != null) {
			al.add(accountobj);
		} else throw new NoSuchAccountException("No Such account id exists in database.",acctid);
		return al;
	}
	/*@Override
	public List<Account> saveDetails(String acctName,
	                                 Float amount,
	                                 String accountType,
	                                 String status,
	                                 Audit auditObj,
	                                 BankDetails bankDetailsObj,
	                                 Contacts contactObj,
	                                 Address addressObj) {
	
		String acctid = autoGenerate.autoGenerateAccountId();
		Account account = new Account();
		account.setAcctId(acctid);
		account.setAcctName(acctName);
		account.setAmount(amount);
		account.setAccountType(accountType);
		account.setStatus(status);
		account.setAudit(auditObj);
		account.setBankDetails(bankDetailsObj);
		account.setContacts(contactObj);
		account.setAddressDetails(addressObj);
		accountRepository.save(account);
		ArrayList<Account> accountList = new ArrayList<>();
		accountList.add(account);
		return accountList;
	}*/

	@Override
	public List<Account> saveDetails(Account accountObj) {

		String acctid = autoGenerate.autoGenerateAccountId();
		//Account newaccount = accountObj;
		if (accountObj != null) {
			accountObj.setAcctId(acctid);
			accountRepository.save(accountObj);
		}
		//newaccount.setAcctId(acctid);
		//accountRepository.save(newaccount);
		ArrayList<Account> accountList = new ArrayList<>();
		accountList.add(accountObj);
		return accountList;
	}

	@Override
	public List<Account> updateDetails(@NotNull Account accountObj) throws RuntimeException {

		Account accountOriginal = null;
		Optional<Account> account = this.accountRepository.findByAcctId(accountObj.getAcctId());
		if (account.isPresent()) {
			accountOriginal = account.get();
		}
			if (accountOriginal != null) {
				try {
				MergeObject.mergetwoObjects(accountObj, accountOriginal);
				} catch (Exception e) {
					e.printStackTrace();
				}
				accountObj = this.accountRepository.save(accountOriginal);
			} else throw new NoSuchAccountException("No Such account id exists in database.",accountObj.getAcctId());
		ArrayList<Account> accountList = new ArrayList<>();
		accountList.add(accountObj);
		return accountList;
	}

	@Override
	public List<Account> deleteDetails(String acctid) throws RuntimeException{

		Account accountOriginal = null;
		Optional<Account> account = this.accountRepository.findByAcctId(acctid);
		if (account.isPresent()) {
			accountOriginal = account.get();
		}
		if (accountOriginal != null) {
			this.accountRepository.delete(accountOriginal);
		} else throw new NoSuchAccountException("No Such account id exists in database.",acctid);
		ArrayList<Account> accountList = new ArrayList<>();
		accountList.add(accountOriginal);
		return accountList;
	}
}
