package com.citi.argentina.ip.gpservice.datafetcher;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.argentina.ip.gpservice.model.Account;
import com.citi.argentina.ip.gpservice.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CreateAccountDataFetcher implements DataFetcher<List<Account>> {

	@Autowired
	AccountService accountservice;
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<Account> get(DataFetchingEnvironment environment) {

		Account accountObj = null;
		Map<String, Object> inputData = environment.getArguments();
		System.out.println("inputData is :" + inputData);
		final ObjectMapper mapper = new ObjectMapper();
		accountObj = mapper.convertValue(inputData, Account.class);
		/*String acctName = environment.getArgument("acctName");
		Float amount = ((Double) environment.getArgument("amount")).floatValue();
		String accountType = environment.getArgument("accountType");
		String status = environment.getArgument("status");
		Audit auditObj = null;
		BankDetails bankDetailsObj = null;
		Contacts contactObj = null;
		Address addressObj = null;
		Object inputQuery = environment.getArguments();
		try {
			String jsonInputString = mapper.writeValueAsString(inputQuery);
			System.out.println("jsonString: " + jsonInputString);
			String nodeAuditString = mapper.readTree(jsonInputString).path("audit").toString();
			String nodeBankDetailsString = mapper.readTree(jsonInputString).path("bankDetails").toString();
			String nodeContactsString = mapper.readTree(jsonInputString).path("contacts").toString();
			String nodeAddressString = mapper.readTree(jsonInputString).path("address").toString();
			//System.out.println("nodeString " + nodeString);
			auditObj = mapper.readValue(nodeAuditString, new TypeReference<Audit>() {
			});
			bankDetailsObj = mapper.readValue(nodeBankDetailsString, new TypeReference<BankDetails>() {
			});
			contactObj = mapper.readValue(nodeContactsString, new TypeReference<Contacts>() {
			});
			addressObj = mapper.readValue(nodeAddressString, new TypeReference<Address>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return accountservice.saveDetails(acctName, amount, accountType, status, auditObj, bankDetailsObj, contactObj, addressObj);
		*/
		return accountservice.saveDetails(accountObj);
	}
}
