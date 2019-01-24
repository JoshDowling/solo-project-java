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
	private String username;
	private String password;
	private String teamName;
	
	
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "accountID")
    private List<Player> player = new ArrayList<>();
	
	
	public Account() {
		
	}


	public Account(long accountID, String username, String password, String teamName, List<Player> player) {
		super();
		this.accountID = accountID;
		this.username = username;
		this.password = password;
		this.teamName = teamName;
		this.player = player;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public List<Player> getPlayer() {
		return player;
	}


	public void setPlayer(List<Player> player) {
		this.player = player;
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
