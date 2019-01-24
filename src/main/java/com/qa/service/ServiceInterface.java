package com.qa.service;

public interface ServiceInterface {
	
	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long accountID, String account);

	String deleteAccount(Long accountID);
	
	String addPlayer(String player);
	
	String deletePlayer(Long id);

}
