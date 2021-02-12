package com.citi.argentina.ip.gpservice.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutoGenerate {

	public String autoGenerateAccountId() {

		Random rand = new Random();
		// Generate random integers in range 0 to 100000
		int autoNumber = rand.nextInt(100001);
		String acctId = "CITI" + autoNumber;
		System.out.println(acctId);
		return acctId;
	}
}