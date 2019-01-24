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

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long accountID;
	@Column(length=20)
	private String username;
	@Column(length=40)
	private String password;
	
	
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "accountID")
    private List<Team> team = new ArrayList<>();
	
	
	public Account() {
		
	}


	public Account(long accountID, String username, String password, List<Team> team) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
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


	public List<Team> getTeam() {
		return team;
	}


	public void setTeam(List<Team> team) {
		this.team = team;
	}


}
