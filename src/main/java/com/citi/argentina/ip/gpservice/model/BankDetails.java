package com.citi.argentina.ip.gpservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class BankDetails {

	private Integer bankId;
	private String bankName;
	private String ifsc;
	private String branchCode;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public BankDetails() {
	}

	public BankDetails(Integer bankId, String bankName, String ifsc, String branchCode) {
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.branchCode = branchCode;
	}
}
