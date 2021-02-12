package com.citi.argentina.ip.gpservice.model;

import com.citi.argentina.ip.gpservice.model.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class AccountTest {

	Account account = new Account();

	@Test
	public void testAcctId() {
		account.setAcctId("CITI001123");
		assertEquals("CITI001123", account.getAcctId());
	}
	@Test
	public void testAcctName() {
		account.setAcctName("Pooja Agarwal");
		assertEquals("Pooja Agarwal", account.getAcctName());
	}

	@Test
	public void testAccType() {
		account.setAccountType("saving");
		assertThat(account.getAccountType()).isSameAs("saving");
	}

	@Test
	public void testAmount() {
		account.setAmount(200f);
		//assertThat(account.getAmount()).isSameAs(200f);
		//assertEquals("200f", account.getAmount());
	}

	@Test
	public void testStatus() {
		account.setStatus("True");
		assertThat(account.getStatus()).isSameAs("True");
	}

	@Test
	public void testAddress() {
		Address add = new Address("A", "B", "Pune", "MH", "India", 123, "Landmark");
		account.setAddressDetails(add);
		assertThat(account.getAddressDetails()).isSameAs(add);
		add = new Address();
		add.setAddressLine1("A");
		assertThat(add.getAddressLine1()).isSameAs("A");
		add.setAddressLine2("B");
		assertThat(add.getAddressLine2()).isSameAs("B");
		add.setCity("Pune");
		assertThat(add.getCity()).isSameAs("Pune");
		add.setState("MH");
		assertThat(add.getState()).isSameAs("MH");
		add.setCountry("India");
		assertThat(add.getCountry()).isSameAs("India");
		add.setZip(123);
		assertThat(add.getZip()).isSameAs(123);
		add.setLandmark("Landmark");
		assertThat(add.getLandmark()).isSameAs("Landmark");
		account.setAddressDetails(add);
		assertThat(account.getAddressDetails()).isSameAs(add);
	}

	@Test
	public void testAudit() {
		Audit audit = new Audit();
		audit.setCreatedBy("Pooja");
		audit.setModifiedBy("Nalini");
		audit.setCreatedDate("10-02-2020");
		audit.setModifiedDate("11-02-2020");
		assertThat(audit.getCreatedBy()).isSameAs("Pooja");
		assertThat(audit.getModifiedBy()).isSameAs("Nalini");
		assertThat(audit.getCreatedDate()).isSameAs("10-02-2020");
		assertThat(audit.getModifiedDate()).isSameAs("11-02-2020");
		account.setAudit(audit);
		assertThat(account.getAudit()).isSameAs(audit);
		audit = new Audit("1", "20-01-2019", "2", "23-09-2020");
		account.setAudit(audit);
		assertThat(account.getAudit()).isSameAs(audit);
	}

	@Test
	public void testBD() {
		//BankDetails db = new BankDetails(123, "ICICI", "ICICI007", "003");
		BankDetails db = new BankDetails();
		//db.setBankId(1234);
		db.setBankName("SBI");
		db.setBranchCode("009");
		db.setIfsc("SBI001122");
		//assertThat(db.getBankId()).isSameAs(1234);
		assertThat(db.getBankName()).isSameAs("SBI");
		assertThat(db.getBranchCode()).isSameAs("009");
		assertThat(db.getIfsc()).isSameAs("SBI001122");
		account.setBankDetails(db);
		assertThat(account.getBankDetails()).isSameAs(db);
		db = new BankDetails(123, "ICICI", "ICICI007", "003");
		account.setBankDetails(db);
		assertThat(account.getBankDetails()).isSameAs(db);
	}

	@Test
	public void testContact() {
		Contacts c = new Contacts("9999999999", "pagarwal6203@altimetrikc.com");
		assertThat(c.getContactNumber()).isSameAs("9999999999");
		assertThat(c.getEmail()).isSameAs("pagarwal6203@altimetrikc.com");
		c.setContactNumber("7205537444");
		c.setEmail("ac@gmail.com");
		assertThat(c.getContactNumber()).isSameAs("7205537444");
		assertThat(c.getEmail()).isSameAs("ac@gmail.com");
		account.setContacts(c);
		assertThat(account.getContacts()).isSameAs(c);
		c = new Contacts();
		account.setContacts(c);
		assertThat(account.getContacts()).isSameAs(c);
	}

}


