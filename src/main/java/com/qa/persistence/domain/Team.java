	package com.qa.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Team {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	private String teamName;
	private long accountID;
	
}
