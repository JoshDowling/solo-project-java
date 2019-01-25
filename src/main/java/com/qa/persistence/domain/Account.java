package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long accountID;
	@Column(unique=true)
	private String username;
	
	private String password;
	
		
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "accountID")
    private Team team;
	
	
	public Account() {
		
	}


	public Account(long accountID, String username, String password, String teamName, List<Player> player) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
			
	}

	
	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public long getAccountID() {
		return accountID;
	}


	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
