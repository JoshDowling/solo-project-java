package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	@Column(length=20)
	private String firstName;
	@Column(length=20)
	private String secondName;
	@Column(length=20)
	private int accountNumber;
	
	public Account() {
		
	}

	public Account(String firstName, String lastName, int accountNumber) {
		super();
		this.firstName = firstName;
		this.secondName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
