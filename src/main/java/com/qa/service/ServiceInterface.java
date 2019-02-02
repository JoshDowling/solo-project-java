package com.qa.service;

public interface ServiceInterface {
	
	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long accountID, String account);

	String deleteAccount(Long accountID);
	
	String addPlayer(String player);
	
	String deletePlayer(Long id);
	
	String addTeam(String team);
	
	String getAllTeams();
	
	String updateTeam(Long teamID, String team);

	String deleteTeam(Long teamID);
	
	String login(String account);

	
}
