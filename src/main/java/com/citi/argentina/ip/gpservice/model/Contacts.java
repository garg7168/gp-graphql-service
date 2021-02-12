package com.citi.argentina.ip.gpservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class Contacts {

	private String contactNumber;
	private String email;

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contacts() {
	}

	public Contacts(String contactNumber, String email) {
		this.contactNumber = contactNumber;
		this.email = email;
	}
}
