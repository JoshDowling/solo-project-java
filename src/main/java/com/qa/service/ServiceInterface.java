package com.qa.service;

public interface ServiceInterface {
	
	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long id, String account);

	String deleteAccount(Long id);

}
