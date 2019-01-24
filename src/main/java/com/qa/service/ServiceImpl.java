package com.qa.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Player;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class ServiceImpl implements ServiceInterface{
	
	private static final Logger LOGGER = Logger.getLogger(ServiceImpl.class);
	
	@Inject
	private AccountRepository repo;
	

	public String getAllAccounts() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		return repo.addAccount(account);
	}

	public String updateAccount(Long accountID, String account) {
		return repo.updateAccount(accountID, account);
	}
 
	public String deleteAccount(Long accountID) {
		return repo.deleteAccount(accountID);

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
}
