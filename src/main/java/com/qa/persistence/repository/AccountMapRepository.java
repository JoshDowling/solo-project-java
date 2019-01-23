package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.HashMap;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;


@Alternative
@RequestScoped
@Transactional(SUPPORTS)
public class AccountMapRepository implements AccountRepository {
	private HashMap<Long, Account> accountList = new HashMap<Long, Account>();
	

	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		return util.getJSONForObject(accountList);
	}
	
	@Transactional(REQUIRED)	
	public String addAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountList.put(newAccount.getId(), newAccount);
				return "{\"message\": \"account has been sucessfully added\"}";
	}
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate, String toChange) {
		Account updateAccount = util.getObjectForJSON(accountToUpdate, Account.class);
		Account accountFromList = accountList.get(id);
		switch(toChange) {
			case "firstName": updateAccount.setFirstName(accountToUpdate);;
				break;
			case "secondName": updateAccount.setSecondName(accountToUpdate);;
				break;

		}
	
		return "{\"message\": \"account has been sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		accountList.remove(id);
		
		return "{\"message\": \"account has been sucessfully deleted\"}";
	}
//	@Transactional(REQUIRED)
//	public String deleteAccount(Long id) {
//		Account accountFromDB = findAccount(id);
//		if(accountFromDB != null) {
//			manager.remove(accountFromDB);
//		}
//		return "{\"message\": \"account has been sucessfully deleted\"}";

	
		
}