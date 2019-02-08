package com.qa.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class ServiceImpl implements ServiceInterface{
	
	private static final Logger LOGGER = Logger.getLogger(ServiceImpl.class);
	
	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		LOGGER.info("In ServiceImpl getAllAccounts ");
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		String accountUser=new Gson().fromJson(account, Account.class).getUsername();
		String[] notAllowed = {"admin", "shit", "fuck", "arse", "undefined", "Brady","brady"};
		for (String i: notAllowed) {
			if (accountUser.contains(i)){
			return "{\"message\": \""+accountUser+" not allowed, account not added.\"}";
		} 
		}
			return repo.addAccount(account);
	}
	public String updateAccount(String username, String account) {
		return repo.updateAccount(username, account);
	}
 
	public String deleteAccount(String username) {
		return repo.deleteAccount(username);

	}
	
	public String addTeam(String team) {
		return repo.addTeam(team);
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

	public String addPlayer(String player) {
		return repo.addPlayer(player);
		
	}

	public String deletePlayer(Long id) {
		return repo.deletePlayer(id);
	}

	public String getAllTeams() {
		LOGGER.info("In ServiceImpl getAllTeams ");
		return repo.getAllTeams();
		
	}

	public String updateTeam(Long teamID, String team) {
		return repo.updateTeam(teamID, team);
		
	}

	public String deleteTeam(Long teamID) {
		return repo.deleteTeam(teamID);
	}

	@Override
	public String login(String account) {
		if (account.contains("undefined")) {
			return null;
		}
		return repo.login(account);
	}
	
}
