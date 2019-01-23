package com.qa.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class ServiceImpl implements ServiceInterface{
	
	private static final Logger LOGGER = Logger.getLogger(ServiceImpl.class);
	
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;
	


	public String getAllAccounts() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		 return repo.addAccount(account);
	}

	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account, account);
	}
 
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);

	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
