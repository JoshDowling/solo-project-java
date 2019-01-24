package com.qa.persistence.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long teamID;
	private String teamName;
	private long accountID;
	
	
//	  @OneToMany(
//	            cascade = CascadeType.ALL,
//	            fetch = FetchType.EAGER
//	    )
//	    @JoinColumn(name = "accountID")
//	    private List<Player> player = new ArrayList<>();
		
	public Team () {
		
	}


	public Team(long teamID, String teamName, long accountID) {
		super();
		this.teamID = teamID;
		this.teamName = teamName;
		this.accountID = accountID;
	}


	public long getTeamID() {
		return teamID;
	}


	public void setTeamID(long teamID) {
		this.teamID = teamID;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public long getAccountID() {
		return accountID;
	}


	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	
	
}